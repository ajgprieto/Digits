package models;

/**
 * A class that creates a model of a Contact.
 * @author AJ
 *
 */
public class Contact {
  
  /**The first name.*/
  public String firstName;
  /**The last name.*/
  public String lastName;
  /**The telephone number.*/
  public String telephone;
  
  /**
   * Default constructor that creates a new Contact.
   *   
   * @param firstName the first name
   * @param lastName the last name
   * @param telephone the telephone number
   */
  public Contact(String firstName, String lastName, String telephone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
  }
  
  /**
   * Returns the first name for the contact.
   * 
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * Returns the last name of the contact.
   * 
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }
  
  
  /**
   * Returns the telephone number for the contact.
   * 
   * @return the telephone number
   */
  public String getTelephone() {
    return telephone;
  }
}
