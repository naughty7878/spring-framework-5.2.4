package com.test.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
// 开启事务管理
@EnableTransactionManagement
@ComponentScan("com.test.tx.service")
public class MainConfig {

	// 数据源
	@Bean("druidDataSource")
	public DataSource druidDataSource(){
		System.out.println("初始化数据源 DruidDataSource ");

		String url="jdbc:mysql://127.0.0.1:3306/test_mybatis?allowPublicKeyRetrieval=true&useSSL=true";
		String username = "root";
		String password = "123456";
		String driverClassName = "com.mysql.cj.jdbc.Driver";

		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setUrl(url);
		druidDataSource.setDriverClassName(driverClassName);

		return druidDataSource;
	}

	// jdbcTemplate
	@Bean
	public JdbcTemplate jdbcTemplate(){
		System.out.println("初始化 JdbcTemplate ");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(druidDataSource());
		return jdbcTemplate;
	}

	// 事物管理器
	@Bean
	public TransactionManager transactionManager(){
		return new DataSourceTransactionManager(druidDataSource());
	}


	// 事务模版
//	@Bean
//	public TransactionTemplate transactionTemplate(){
//		// DataSourceTransactionManager 实现了 PlatformTransactionManager 接口
//		TransactionTemplate template = new TransactionTemplate((PlatformTransactionManager)transactionManager() );
//		// 设置隔离级别，重复读取
//		template.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
//		// 设置传播行为，重复读取
//		template.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		return template;
//	}
}
