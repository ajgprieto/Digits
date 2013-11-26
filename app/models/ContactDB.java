package models;

import java.util.List;
import views.formdata.ContactFormData;

/**
 * Simulates a database of contacts.
 * 
 * @author AJ
 * 
 */
public class ContactDB {

  /**
   * public static void add(ContactFormData contact)
   * 
   * Adds the given ContactFormData to the Contact List.
   * 
   * @param user the user
   * @param formData the contact to be added
   */
  public static void add(String user, ContactFormData formData) {

    boolean isNewContact = (formData.id == -1);

    if (isNewContact) {
      Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
      UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
      if (userInfo == null) {
        throw new RuntimeException("User not found: " + user);
      }
      userInfo.addContact(contact);
      contact.setUserInfo(userInfo);
      contact.save();
      userInfo.save();
    }
    else {
      Contact contact = Contact.find().byId(formData.id);

      System.out.println(formData.firstName);
      contact.setFirstName(formData.firstName);
      contact.setLastName(formData.lastName);
      contact.setNumber(formData.telephone);
      contact.setTelephoneType(formData.telephoneType);
      contact.save();
    }

  }

  /**
   * Checks to see if it is a valid user.
   * 
   * @param user the user
   * @return true if that user exists.
   */
  public static boolean isUser(String user) {
    return (UserInfo.find().where().eq("email", user).findUnique() != null);
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
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Not a valid contact.");
    }
    UserInfo userInfo = contact.getUserInfo();
    if (!user.equals(userInfo.getEmail())) {
      throw new RuntimeException("User not associated with contact.");
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
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    if (userInfo == null) {
      return null;
    }
    else {
      return userInfo.getContacts();
    }
  }

}
