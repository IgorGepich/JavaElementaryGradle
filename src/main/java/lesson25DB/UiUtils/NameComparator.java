package lesson25DB.UiUtils;

import lesson25DB.Contact;

import java.util.Comparator;

public class NameComparator {

	public static Comparator<Contact> NameComparator = Comparator.comparing(Contact::getFirstName);

	public static Comparator<Contact>SameName = (contact1, contact2) -> {
		int result = contact1.getFirstName().compareTo(contact2.getFirstName());
		return result;
	};
}
