package com.zensar.bookmanagement.provider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

	public static Connection getConnection() {

		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileReader(new File(".\\resources\\db.properties")));
			String driver = properties.getProperty("driverClass");
			String url = properties.getProperty("url");
			String userName = properties.getProperty("user");
			String password = properties.getProperty("password");
			Class.forName(driver);
			con = DriverManager.getConnection(url,userName,password);
			return con;
		} catch (IOException|ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		} 
		return con;
	}
}
