package com.algoda.util;

import java.sql.*;

import javax.servlet.ServletContext;

public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnect() {
		
	try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@ptax15g6ez0tr2te_low?TNS_ADMIN=C://LSM//wallet//Wallet_PTAX15G6EZ0TR2TE";
			String id="admin";
			String pwd="JaewonChung73";
			System.out.println("연결 성공");
			
			con = DriverManager.getConnection(url,id,pwd);
		} catch (SQLException e) {
				e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public JDBConnect(String driver, String url, String id , String pwd) {
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("연결 성공");
			
		} catch (SQLException e) {
				e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public JDBConnect(ServletContext application) {

		String driver = application.getInitParameter("OracleDriver");
		try {
			Class.forName(driver);
			String url=application.getInitParameter("OracleURL");
			String id =application.getInitParameter("OracleId");
			String pwd=application.getInitParameter("OraclePwd");
			
			
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("연결 성공");
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			if(rs != null)rs.close();
			if(stmt != null)stmt.close();
			if(psmt != null)psmt.close();
			if(con != null)con.close();
			System.out.println("자원 해제");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
