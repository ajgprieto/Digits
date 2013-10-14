package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * A database to hold the Contacts.
 * 
 * @author AJ
 *
 */
public class ContactDB {
  
  /**The List that will contain the contacts.*/
  public static List<Contact> contacts = new ArrayList<>();
  
 /**
  * public static void add(ContaactFormData contact)
  * 
  * Adds a contact to contacts.
  * 
  * @param contact the contact to be added
  */
  public static void add(ContactFormData contact) {
    Contact newContact = new Contact(contact.firstName, contact.lastName, contact.telephone);
    contacts.add(newContact);  
  }
  
  /**
   * public List<Contact> listContacts()
   * 
   * Lists the contacts that are in the database.
   * 
   * @return the list of contacts
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
  
}
