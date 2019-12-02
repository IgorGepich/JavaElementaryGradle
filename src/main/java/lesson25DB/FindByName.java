package lesson25DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class FindByName extends DbConnection {

	void findName(){
	Statement statement = null;
	System.out.println("Enter name to find: ");
	String nameToFind = userInput.nextLine();
	System.out.println("Find contacts in data base:");
		try {
			statement = this.connection.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try{
			ResultSet cursor = statement.executeQuery("SELECT * FROM contacts_table" +
					" WHERE name LIKE '%"+ nameToFind +"%';");
			while (cursor.next()) {
				System.out.printf("%d | %s | %s | %s \n",
						cursor.getInt("id"),
						cursor.getString("name"),
						cursor.getString("lastName"),
						cursor.getString("phoneNumber"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}

