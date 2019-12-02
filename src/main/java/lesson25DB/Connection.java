package lesson25DB;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Connection {
	private static final String DB_CONNECTION = "jdbc:sqlite:/Volumes/Work/java_db/idea_test_db.db";

	java.sql.Connection connection;

	Connection() {
		try {DriverManager.registerDriver(new JDBC());
		this.connection = DriverManager.getConnection(DB_CONNECTION);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	List<Contact> getAllContacts() {
		try (Statement statement = this.connection.createStatement()){
			List<Contact> contacts = new ArrayList<>();
			ResultSet cursor = statement.executeQuery("SELECT id, name, phoneNumber FROM Contact");
				while (cursor.next()){
					contacts.add(new Contact(cursor.getInt("id"),
											cursor.getString("name"),
											cursor.getString("lastName"),
											cursor.getString("phoneNumber")));
				}
					for (Contact contact : contacts) {
						System.out.println(contact.toString());
					}
		return contacts;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Add contact to db.
	 * @param contact - object with fields name & phoneNumber.
	 */
	void addContact(Contact contact) {
		try(PreparedStatement statement = this.connection.prepareStatement(
				"INSERT INTO Contact('name', 'phoneNumber') VALUES (?, ?)")) {
				statement.setString(1, contact.firstName);
				statement.setString(2, contact.phoneNumber);
				statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete Contact from db by field NAME
	 * @param name - contact name field
	 */
	void deleteContact(String name) {
		try(PreparedStatement statement = this.connection.prepareStatement(
				"DELETE FROM Contact WHERE name = ?")) {
			statement.setString(1, name);
			statement.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
			System.out.println("Deleted contact name: " + name);
	}

	void deleteAllContacts(){
		try(PreparedStatement statement = this.connection.prepareStatement(
				" DELETE FROM Contact; DELETE FROM sqlite_sequence")) {
//				"UPDATE sqlite_sequence SET seq=0 WHERE NAME=seq")) {
			statement.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println("Delete all contacts from db.");
	}
}
