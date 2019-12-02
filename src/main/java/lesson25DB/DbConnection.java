package lesson25DB;

import org.sqlite.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

class DbConnection {

	private static final String DB_CONNECTION = "jdbc:sqlite:/Volumes/Work/java_db/contacts.db";

	java.sql.Connection connection;

	Scanner userInput = new Scanner(System.in);

	DbConnection() {
		try {
			DriverManager.registerDriver(new JDBC());
			this.connection = DriverManager.getConnection(DB_CONNECTION);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
