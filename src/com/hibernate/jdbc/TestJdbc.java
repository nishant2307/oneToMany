package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false";
		String user = "Nishant";
		String pass= "Nish2018";
		try {
			
			System.out.println("Connecting to database"+ jdbcUrl);
			 Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			 System.out.println("connection successful");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
