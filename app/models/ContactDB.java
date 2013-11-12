package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Simulates a database of contacts.
 * 
 * @author AJ
 * 
 */
public class ContactDB {

  /** The Map containing the Contacts along with their IDs. */
  private static Map<String, Map<Long, Contact>> contacts = new HashMap<>();

  /**
   * public static void add(ContactFormData contact)
   * 
   * Adds the given ContactFormData to the Contact List.
   * 
   * @param user the user
   * @param formData the contact to be added
   */
  public static void add(String user, ContactFormData formData) {
    Contact contact;
    long id;
    if (formData.id == 0) {
      id = contacts.size() + 1;
      System.out.println(id);
      contact = new Contact(id, formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
    }
    else {
      id = formData.id;
      contact =
          new Contact(formData.id, formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
    }
    if (!isUser(user)) {
      contacts.put(user, new HashMap<Long, Contact>());
    }
    contacts.get(user).put(id, contact);
  }

  /**
   * Checks to see if it is a valid user.
   * 
   * @param user the user
   * @return true if that user exists.
   */
  public static boolean isUser(String user) {
    return contacts.containsKey(user);
  }

  /**
   * Returns the contact that belongs to the ID.
   * 
   * @param id the id to be looked for
   * @param user the user
   * 
   * @return the contact if found, otherwise a Runtime Exception is thrown
   */
  public static Contact getContact(String user, long id) {
    if (!isUser(user)) {
      throw new RuntimeException("Not a valid user.");
    }
    Contact contact = contacts.get(user).get(id);
    if (contact == null) {
      throw new RuntimeException("Not a valid id.");
    }
    return contact;
  }

  /**
   * public static List<Contact> getContacts()
   * 
   * Returns the list of contacts.
   * 
   * @param user the user
   * 
   * @return contactList = the list of contacts
   */
  public static List<Contact> getContacts(String user) {
    if (!isUser(user)) {
      throw new RuntimeException("Not a valid user.");
    }
    return new ArrayList<>(contacts.get(user).values());
  }

}
