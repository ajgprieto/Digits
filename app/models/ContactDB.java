package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Simulates a database of contacts.
 * 
 * @author AJ
 *
 */
public class ContactDB {
  
  static List<Contact> contactList = new ArrayList<>();
  
  /**
   * public static void add(ContactFormData contact)
   * 
   * Adds the given ContactFormData to the Contact List.
   * 
   * @param contact the contact to be added
   */
  public static void add(ContactFormData contact) {
    Contact newContact = new Contact(contact.firstName, contact.lastName, contact.telephone, contact.address);
    contactList.add(newContact);
  }
  
  /**
   * public static List<Contact> getContacts()
   * 
   * Returns the list of contacts.
   * 
   * @return contactList = the list of contacts
   */
  public static List<Contact> getContacts() {
    return contactList;
  }

}
