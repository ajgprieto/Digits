package models;

/**
 * Provides MySQL repository for UserInfo. Storing credentials in the clear is kind of bogus.
 * 
 * @author Philip Johnson
 */
public class UserInfoDB {

  /**
   * Defines an admin account.
   * 
   * @param name the admin name
   * @param email the admin email
   * @param password the admin password
   */
  public static void defineAdmin(String name, String email, String password) {
    if (name != null && email != null && password != null && !hasAdmin()) {
      UserInfo userInfo = new UserInfo(name, email, password);
      userInfo.setAdmin(true);
      userInfo.save();
    }
  }

  /**
   * Checks if app has an admin.
   * 
   * @return true if admin credentials defined.
   */
  public static boolean hasAdmin() {
    UserInfo userInfo = UserInfo.find().where().eq("admin", true).findUnique();
    return userInfo != null;
  }

  /**
   * Adds the specified user to the UserInfoDB.
   * 
   * @param name Their name.
   * @param email Their email.
   * @param password Their password.
   */
  public static void addUserInfo(String name, String email, String password) {
    UserInfo userInfo = new UserInfo(name, email, password);
    userInfo.save();
  }

  /**
   * Returns true if the email represents a known user.
   * 
   * @param email The email.
   * @return True if known user.
   */
  public static boolean isUser(String email) {
    return UserInfo.find().where().eq("email", email).findUnique() != null;
  }

  /**
   * Returns the UserInfo associated with the email, or null if not found.
   * 
   * @param email The email.
   * @return The UserInfo.
   */
  public static UserInfo getUser(String email) {
    return UserInfo.find().where().eq("email", email).findUnique();
  }

  /**
   * Returns true if email and password are valid credentials.
   * 
   * @param email The email.
   * @param password The password.
   * @return True if email is a valid user email and password is valid for that email.
   */
  public static boolean isValid(String email, String password) {
    return ((email != null) && (password != null) && isUser(email) && getUser(email).getPassword().equals(password));
  }
}
