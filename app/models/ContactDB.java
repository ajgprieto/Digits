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
  private static Map<Long, Contact> contacts = new HashMap<>();

  /**
   * public static void add(ContactFormData contact)
   * 
   * Adds the given ContactFormData to the Contact List.
   * 
   * @param formData the contact to be added
   */
  public static void add(ContactFormData formData) {
    Contact contact;
    long id;
    if (formData.id == 0) {
     id = contacts.size() + 1;
      System.out.println(id);
      contact = new Contact(id, formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
      contacts.put(id, contact);
    }
    else {
      Contact newContact =
          new Contact(formData.id, formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
      contacts.put(newContact.getID(), newContact);
    }
  }

  /**
   * Returns the contact that belongs to the ID.
   * 
   * @param id the id to be looked for
   * 
   * @return the contact if found, otherwise a Runtime Exception is thrown
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Invalid ID.");
    }
    return contact;
  }

  /**
   * public static List<Contact> getContacts()
   * 
   * Returns the list of contacts.
   * 
   * @return contactList = the list of contacts
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }

}
