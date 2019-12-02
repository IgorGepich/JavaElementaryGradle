package lesson25DB;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateDeleteTable extends DbConnection {

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

	void deleteTable() {
		try (Statement statement = super.connection.createStatement()) {
			statement.executeUpdate("DROP TABLE contacts_table; DELETE FROM sqlite_sequence");
			System.out.println("Delete table Contacts from DB.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
