package com.test.tx;

import com.test.tx.service.IOutService;
import com.test.tx.service.ITargetService;
import com.test.tx.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class MainStarter2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		try {

		}catch (Exception e) {
			TestService testService = context.getBean(TestService.class);
			testService.test2();
		}

		ITargetService targetService = context.getBean(ITargetService.class);
		targetService.select();
//		TransactionTemplate template = context.getBean(TransactionTemplate.class);
//		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//
//		// 事务定义
//		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//		// 设置隔离级别
//		def.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
//		// 设置传播行为
//		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		//事务状态类，通过PlatformTransactionManager的getTransaction方法根据事务定义获取；获取事务状态后，Spring根据传播行为来决定如何开启事务
//		TransactionStatus status = txManager.getTransaction(def);
//		jdbcTemplate = new JdbcTemplate(dataSource);
//		int i = jdbcTemplate.queryForInt(COUNT_SQL);
//		System.out.println("表中记录总数："+i);
//		try {
//			jdbcTemplate.update(INSERT_SQL, "1");
//			txManager.commit(status);  //提交status中绑定的事务
//		} catch (RuntimeException e) {
//			txManager.rollback(status);  //回滚
//		}
//		i = jdbcTemplate.queryForInt(COUNT_SQL);
//		System.out.println("表中记录总数："+i);
//
//		// 构造函数初始化TransactionTemplate
////		TransactionTemplate template = new TransactionTemplate(transactionManager);
//		// 设置隔离级别，重复读取
//		template.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
//		//
//		template.execute(new TransactionCallbackWithoutResult() {
//							 @Override
//							 protected void doInTransactionWithoutResult(TransactionStatus status) {
//								 // 字段sd为int型，所以插入肯定失败报异常，自动回滚，代表TransactionTemplate自动管理事务
//								 jdbcTemplate.update("update user_tx set name = '王四' where id = 3");
////								 throw new RuntimeException();
//							 }
//						 }
//		);
	}



}
