package lesson25DB;

import java.sql.SQLException;
import java.sql.Statement;

class AddContact extends DbConnection  {

	/**
	 * Add contact to db.
	 */
	void addContact() {
		System.out.println("Enter first name of the contact: ");
		String firstName = userInput.nextLine();
		System.out.println("Enter last name of the contact: ");
		String lastName = userInput.nextLine();
		System.out.println("Enter phone number: ");
		String phoneNumber = userInput.nextLine();
		String sql = "INSERT INTO contacts_table('name', 'lastName', 'phoneNumber') VALUES('%s', '%s', '%s')";
		try (Statement statement = super.connection.createStatement()){
			statement.executeUpdate(String.format(sql, firstName, lastName, phoneNumber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
