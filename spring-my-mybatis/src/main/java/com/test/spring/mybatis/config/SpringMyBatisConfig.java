package com.test.spring.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.test.spring.mybatis.entity.Employee;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.test.spring.mybatis.service")
@MapperScan("com.test.spring.mybatis.mapper")
public class SpringMyBatisConfig {

	// 数据源
	@Bean("dataSource")
	public DataSource dataSource(){
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

	// 事物管理器
	@Bean
	public TransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}

	// SqlSeesion工厂Bean
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		// 设置 MyBatis 配置文件路径
		factoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
		// 设置 SQL 映射文件路径
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
		// 这是类型别名
//		factoryBean.setTypeAliases(new Class[]{Employee.class});
		return factoryBean;
	}
}
