package lesson25DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindByName extends DbConnection {

	String nameToFind = "igor";

	void findName(){
	Statement statement = null;
		try {
			statement = this.connection.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try{
			ResultSet cursor = statement.executeQuery("SELECT * FROM contacts_table" +
					" WHERE name LIKE '%"+ nameToFind +"%';");
			while (cursor.next()) {
				System.out.printf("%d, %s, %s, %s \n",
						cursor.getInt("id"),
						cursor.getString("name"),
						cursor.getString("lastName"),
						cursor.getString("phoneNumber")
				);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}

