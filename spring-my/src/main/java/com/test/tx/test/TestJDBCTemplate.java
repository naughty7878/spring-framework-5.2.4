package com.test.tx.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestJDBCTemplate {
	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://127.0.0.1:3306/test_mybatis?allowPublicKeyRetrieval=true&useSSL=true";
		String username = "root";
		String password = "123456";
		String driverClassName = "com.mysql.cj.jdbc.Driver";

		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setUrl(url);
		druidDataSource.setDriverClassName(driverClassName);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(druidDataSource);

		//3: 编写SQL
		String sql="select id,name from user";

		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

		maps.forEach(t ->  System.out.println("id:"+t.get("id")+"\t名称:"+t.get("name")));
	}
}
