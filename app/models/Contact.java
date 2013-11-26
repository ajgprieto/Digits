package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * Creates a model of a Contact.
 */
@Entity
public class Contact extends Model {

  private static final long serialVersionUID = 1L;

  @Id
  private Long id;
  /** The first name. */
  private String firstName;
  /** The last name. */
  private String lastName;
  /** The telephone number. */
  private String telephone;
  /** The telephone type. */
  private String telephoneType;

  @ManyToOne
  private UserInfo userInfo;

  /**
   * public Contact(String first, String last, String phNumber
   * 
   * Creates a Contact from the given data.
   * 
   * @param first the first name
   * @param last the last name
   * @param phNumber the phone number
   * @param telephoneType the telephone type
   */
  public Contact(String first, String last, String phNumber, String telephoneType) {
    this.firstName = first;
    this.lastName = last;
    this.telephone = phNumber;
    this.telephoneType = telephoneType;
  }

  /**
   * Returns the first name.
   * 
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name of the contact.
   * 
   * @param name the first name
   */
  public void setFirstName(String name) {
    this.firstName = name;
  }

  /**
   * Returns the last name.
   * 
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name of the contact.
   * 
   * @param name the last name
   */
  public void setLastName(String name) {
    this.lastName = name;
  }

  /**
   * Returns the phone number.
   * 
   * @return the phone number
   */
  public String getNumber() {
    return telephone;
  }

  /**
   * Sets the number for the contact.
   * 
   * @param num the number for the contact.
   */
  public void setNumber(String num) {
    this.telephone = num;
  }

  /**
   * Returns the contact's id.
   * 
   * @return the id
   */
  public long getID() {
    return id;
  }

  /**
   * Sets the contact's id.
   * 
   * @param id the contact's id
   */
  public void setID(long id) {
    this.id = id;
  }

  /**
   * Returns the telephone type.
   * 
   * @return the telephone type
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /**
   * Sets the telephone type.
   * 
   * @param telephoneType the telephone type to be set
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * The EBean ORM finder method for database queries on ID.
   * 
   * @return The finder method for Contacts.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }

  /**
   * Sets the userInfo to userInfo.
   * 
   * @param userInfo the userInfo
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  /**
   * Returns the userinfo.
   * 
   * @return the userinfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }
}
