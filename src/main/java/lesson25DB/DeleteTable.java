package lesson25DB;

import java.sql.SQLException;
import java.sql.Statement;

class DeleteTable extends DbConnection {
	/**
	 * Class for deleting table from database.
	 */
	void deleteTable() {
		try (Statement statement = super.connection.createStatement()) {
			statement.executeUpdate("DROP TABLE contacts_table;" +
					"DELETE FROM contacts_table");
			System.out.println("Delete table contacts_table from DB.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
