package models;

/**
 * Creates a model of a Contact.
 */
public class Contact {
  
  /**The first name.*/
  private String firstName;
  /**The last name.*/
  private String lastName;
  /**The telephone number.*/
  private String telephone;
  /**The address.*/
  private String address;
  
  /**
   * public Contact(String first, String last, String phNumber
   * 
   * Creates a Contact from the given data.
   * 
   * @param first the first name
   * @param last the last name
   * @param phNumber the phone number
   * @param address, the address 
   */
  public Contact(String first, String last, String phNumber, String address) {
    this.firstName = first;
    this.lastName = last;
    this.telephone = phNumber;
    this.address = address;
  }
  
  /**
   * public String getFirstName()
   * 
   * Returns the first name.
   * 
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * public String getLastName()
   * 
   * Returns the last name.
   * 
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * public String getNumber()
   * 
   * Returns the phone number.
   * 
   * @return the phone number
   */
  public String getNumber() {
    return telephone;
  }
  
  /**
   * 
   * @return the address
   */
  public String getAddress() {
    return address;
  }
  
}
