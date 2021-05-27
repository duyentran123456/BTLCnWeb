package cnweb.db;

import java.sql.Connection;
import java.sql.DriverManager;

import cnweb.config.DatabaseConfig;

public class MySQLConnection implements DBConnection {
	
	@Override
	public Connection getConnection() {
		try {
			Class.forName(DatabaseConfig.driverName);

			String url = DatabaseConfig.url;
			String user = DatabaseConfig.username;
			String password = DatabaseConfig.password;
			
			Connection conn = DriverManager.getConnection(url, user, password);

			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
