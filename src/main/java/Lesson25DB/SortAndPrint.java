package Lesson25DB;

import Lesson25DB.UiUtils.NameComparator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SortAndPrint extends DbConnection {

	/**
	 * Sort all contacts by field First Name
	 * @return
	 */
	List<Contact> contacts = new ArrayList<>();
	List<Contact> getAllSortedContacts() {
		try (Statement statement = this.connection.createStatement()){
			ResultSet cursor = statement.executeQuery("SELECT id, " +
					"name, " +
					"lastName, " +
					"phoneNumber " +
					"FROM contacts_table");
			while (cursor.next()){
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
			return contacts;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	//TODO
	void findContact(){
		Scanner scanner = new Scanner(System.in);
		String nameToFind = scanner.nextLine();
		if(Arrays.asList(contacts).contains(nameToFind)){
			System.out.println("Contains");
		} else {
			System.out.println("Not");
		}
	}
}
