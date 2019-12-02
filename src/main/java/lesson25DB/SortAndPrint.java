package lesson25DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class SortAndPrint extends DbConnection {
	/**
	 * Sort all contacts by field First Name and it to CLI.
	 */
	void getAllSortedContacts() {
		Statement statement = null;
		try {
			statement = this.connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ResultSet cursor = statement.executeQuery("SELECT id, " +
					"name, " +
					"lastName, " +
					"phoneNumber " +
					"FROM contacts_table ORDER BY name");
			while (cursor.next()) {
				System.out.printf("%d | %s | %s | %s \n",
						cursor.getInt("id"),
						cursor.getString("name"),
						cursor.getString("lastName"),
						cursor.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * Sort all contacts by field First Name. Second realisation for myself
	 * DEPRECATED METHOD
	 */
	private List<Contact> contacts = new ArrayList<>();

	void getAllSortedContactsCollection() {
		try (Statement statement = this.connection.createStatement()) {
			ResultSet cursor = statement.executeQuery("SELECT id, " +
					"name, " +
					"lastName, " +
					"phoneNumber " +
					"FROM contacts_table");
			while (cursor.next()) {
				contacts.add(new Contact(
						cursor.getInt("id"),
						cursor.getString("name"),
						cursor.getString("lastName"),
						cursor.getString("phoneNumber")));
			}
			contacts.sort(NameComparator.NameComparator);
			for (Contact contact : contacts) {
				System.out.println(contact.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
