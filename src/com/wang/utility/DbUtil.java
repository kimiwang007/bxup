package com.wang.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	public Connection getConn() {
		
		Connection conn = null;
		try {
			/*
			 * Driver = "com.mysql.jdbc.Driver"; url =
			 * "jdbc:mysql://43.82.163.62/testdb?"; userName = "root"; password
			 * = "morning";
			 */
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
			/* �v���p�e�B�̎��o�� */    
			String Driver = properties.getProperty("Driver"); // JDBC�h���C�o��
			String url = properties.getProperty("jdbc_url"); // JDBC�h���C�o��
			String userName = properties.getProperty("jdbc_username"); // JDBC�h���C�o��
			String password = properties.getProperty("jdbc_password"); // JDBC�h���C�o��

			Class.forName(Driver);

			conn = DriverManager.getConnection(url, userName, password);

		} catch (IOException e) {

		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
