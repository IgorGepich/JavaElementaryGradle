package lesson25DB;

import lesson25DB.UiUtils.NameComparator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class SortAndPrint extends DbConnection {

	/**
	 * Sort all contacts by field First Name second rea
	 */
//	private List<Contact> contacts = new ArrayList<>();
//	void getAllSortedContacts() {
//		try (Statement statement = this.connection.createStatement()) {
//			ResultSet cursor = statement.executeQuery("SELECT id, " +
//					"name, " +
//					"lastName, " +
//					"phoneNumber " +
//					"FROM contacts_table");
//			while (cursor.next()){
//				contacts.add(new Contact(
//						cursor.getInt("id"),
//						cursor.getString("name"),
//						cursor.getString("lastName"),
//						cursor.getString("phoneNumber")));
//			}
//			contacts.sort(NameComparator.NameComparator);
//			for (Contact contact : contacts) {
//				System.out.println(contact.toString());
//			}
//		} catch (SQLException e){
//			e.printStackTrace();
//		} finally {
//
//		}
//	}

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
			while (cursor.next()){
				System.out.printf("%d, %s, %s, %s \n",
						cursor.getInt("id"),
						cursor.getString("name"),
						cursor.getString("lastName"),
						cursor.getString("phoneNumber")
				);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 Realization of Find and FindStudentByName methods can find Student by name, or by partial name match.
	 */


}
