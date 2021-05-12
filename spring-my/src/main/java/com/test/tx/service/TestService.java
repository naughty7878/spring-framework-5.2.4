package com.test.tx.service;

import com.test.tx.MainConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class TestService {

	// 事务模版
	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private TransactionManager transactionManager;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void test1() {
		PlatformTransactionManager txManager = (PlatformTransactionManager) this.transactionManager;
		// 定义事务隔离级别，传播行为，
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// 事务状态类，通过PlatformTransactionManager的getTransaction方法根据事务定义获取；
		// 获取事务状态后，Spring根据传播行为来决定如何开启事务
		TransactionStatus status = txManager.getTransaction(def);
		try {
			jdbcTemplate.update("update user_tx set name = '王五' where id = 3");
			int n = 1/0;
			// 提交status中绑定的事务
			txManager.commit(status);
		} catch (RuntimeException e) {
			// 回滚status中绑定的事务
			txManager.rollback(status);
		}
	}

	public void test2() {

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
							 // 在事务中执行，且没有结果返回
							 @Override
							 protected void doInTransactionWithoutResult(TransactionStatus status) {
								 // 报异常，自动回滚，代表TransactionTemplate自动管理事务
								 jdbcTemplate.update("update user_tx set name = '王五' where id = 3");
								 throw new RuntimeException();
							 }
						 }
		);

		// 有结果返回的执行
//		Object result = transactionTemplate.execute(new TransactionCallback<Object>() {
//			// 在事务中执行
//			@Override
//			public Object doInTransaction(TransactionStatus status) {
//				return null;
//			}
//		});
	}
}
