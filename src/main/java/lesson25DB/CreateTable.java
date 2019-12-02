package lesson25DB;

import java.sql.SQLException;
import java.sql.Statement;

class CreateTable extends DbConnection {

	void createTable() {
		try (Statement statement = super.connection.createStatement()) {
			statement.executeUpdate("CREATE TABLE contacts_table " +
					"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
					"name String, " +
					"lastName String, " +
					"phoneNumber String)");
			System.out.println("Create table Contacts in DB.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
