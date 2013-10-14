package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

/**
 * Simple contact form data.
 * 
 * @author AJ
 * 
 */
public class ContactFormData {

  private static final int NUM_DIGITS = 12;

  /** The first name. */
  public String firstName = "";

  /** The last name. */
  public String lastName = "";

  /** The telephone number. */
  public String telephone = "";
  
  /**
   * public List<ValidationError> validate()
   * 
   * Validates that info given is correct and not empty.
   * 
   * @return List of errors if applicable.
   */
  public List<ValidationError> validate() {
    
    List<ValidationError> error = new ArrayList<>();
    
    if (firstName == null || firstName.length() == 0) {
      error.add(new ValidationError("firstName", "First Name is required."));
    }
    if (lastName == null || lastName.length() == 0) {
      error.add(new ValidationError("lastName", "Last Name is required."));
    }
    if (telephone == null || telephone.length() == 0) {
      error.add(new ValidationError("telephone", "Telephone Number is required."));
    }
    if (telephone.length() != NUM_DIGITS) {
      error.add(new ValidationError("telephone", "Telephone Number must be 12 characters long."));
    }
    return error.isEmpty() ? null : error;
  }

}
