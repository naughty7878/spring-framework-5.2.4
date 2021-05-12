package com.test.tx.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDruidDataSource {
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

		DruidPooledConnection con = druidDataSource.getConnection();


		//3: 编写SQL
		String sql="select id,name from user";

		//4: 建立一个预处理的声明对象: 解释sql  发送SQL
		PreparedStatement pre=con.prepareStatement(sql);

		//5: 发送SQL  返回一个ResultSet
		ResultSet rs=pre.executeQuery();

		//6:编历结果集
		while(rs.next())//从数据库的取一行数据，是否还有下一行
		{
			int id=rs.getInt(1);  //从1开始
			String name=rs.getString(2);
			System.out.println("id:"+id+"\t名称:"+name);
		}

		//7: 关闭连接
		con.close();
	}
}
