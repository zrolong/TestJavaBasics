package com.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.6:3306/test","root","3529");
			
			stmt = conn.createStatement();
			String name = "����";
			String sql = "insert into t_user (username,pwd,regTime) values ('"+name+"',66666,now())";
			
			//stmt = conn.createStatement();
			//String id = "5 or 1=1 ";
			//String sql = "delete from t_user where id="+id;
			
			stmt.execute(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
