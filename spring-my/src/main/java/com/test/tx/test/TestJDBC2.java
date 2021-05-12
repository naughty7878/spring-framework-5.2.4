package com.test.tx.test;

import java.sql.*;

public class TestJDBC2 {

    /**
     *     JDBC --java database connection (JAVA 数据据连接技术)它是一个接口
     *     步骤：
     *  1: 加载驱动
     *  2: 得到联接对象  connection
     *  3: 编写SQL
     *  4: 建立一个预处理的声明对象: 解释sql  发送SQL
     *  5: 发送SQL  返回一个ResultSet
     *          .executeQuery(); 发送一个查询的SQL语句，  返回一个ResultSet
     *          .executeUpdate();发送一个非查询的SQL语句，  返回一个 int n （代表是数据库受影响的行数）
     *          .execute();发送一个SQL语句，  返回一个 boolean (是否有ResultSet)
     *  6: 编历结果集
     *  7: 关闭连接
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

            //1: 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2: 得到联接对象  connection
            String url="jdbc:mysql://127.0.0.1:3306/test_mybatis?allowPublicKeyRetrieval=true&useSSL=true";
            Connection con=DriverManager.getConnection(url,"root","123456");

		int transactionIsolation = con.getTransactionIsolation();
		System.out.println(transactionIsolation);

		try {
				// 开启事物
				// 开启手动事务的关键是con.setAutoCommit(false)，JDBC事务默认是开启的，并且是自动提交：
				// 关闭自动提交：java.sql.Connection.setAutoCommit(false)
				// setAutoCommit(true)：每次操作都会被认为是一个事务并且自动提交
				con.setAutoCommit(false);

				//3: 编写SQL
				String sql="update user_tx set name = '王五' where id = 3";

				//4: 建立一个预处理的声明对象: 解释sql  发送SQL
				PreparedStatement pre=con.prepareStatement(sql);

				//5: 发送SQL  返回一个ResultSet
				boolean result = pre.execute(sql);

				int n = 1/0;

				// 手动提交事务
				con.commit();
			} catch (Exception e) {
				// 出现异常时回滚，不一定在catch语句中，
				// 只要在con.commit()前需要回滚时执行都可
				con.rollback();
			} finally {
				//7: 关闭连接
				con.close();
			}

    }
}