package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.UserInfo;
import models.UserInfoDB;
import play.data.validation.ValidationError;

/**
 * A class for the registration form.
 * @author AJ
 *
 */
public class RegistrationFormData {

  /**User's name. */
  public String name;
  /**User's email. */
  public String email;
  /**User's password.*/
  public String password;
  
  /**
   * Creates a new registration form.
   * @param user the user
   */
  public RegistrationFormData(UserInfo user) {
    this.name = user.getName();
    this.email = user.getEmail();
    this.password = user.getPassword();
  }
  
  /**
   * Validates the given information.
   * @return the list of errors
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError(name, "Name cannot be empty."));
    }
    if (password == null || password.length() == 0) {
      errors.add(new ValidationError(password, "Password cannot be empty."));
    }
    if (UserInfoDB.isUser(email)) {
      errors.add(new ValidationError(email, "Already a registered user."));
    }
    
    return errors.isEmpty() ? errors : null;
  }
}
