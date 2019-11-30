package Lesson25DB;

public class Contact {

	private int id;
	String firstName;
	String lastName;
	String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	Contact(int id, String firstName, String lastName, String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	Contact(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return String.format("ID: %d | Contact name: %s | Contact last name: %s | Phone number: %s",
				this.id, this.firstName, this.lastName, this.phoneNumber);
	}
}
