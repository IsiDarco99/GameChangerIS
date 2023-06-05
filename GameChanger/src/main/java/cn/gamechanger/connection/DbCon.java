package cn.gamechanger.connection;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	
	// Costruttore privato
	  private DbCon() {
	    // Vuoto, non fa nulla
	  }
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamechanger","root","password");
			logger.info("Connected");
		}
		return connection;
	}
}
