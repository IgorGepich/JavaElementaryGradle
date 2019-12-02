package lesson25DB;

import java.util.Comparator;

/**
 * Comparator realised for myself
 */

public class NameComparator {

	static Comparator<Contact> NameComparator = Comparator.comparing(Contact::getFirstName);

	public static Comparator<Contact>SameName = Comparator.comparing(Contact::getFirstName);
}
