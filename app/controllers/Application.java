package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Home;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

 
  /**
   * Returns home, a page that contains sample contacts.
   * @return The Home.
   */
  public static Result home() {
    return ok(Home.render());
  }
  
  /**
   * Returns newcontact, a page that simulates an add contact page.
   * @return The NewContact.
   */
  public static Result newContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));
  }
  
  /**
   * Posts the contact info to the Play console. 
   * @return contact info to the play console.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    ContactFormData data = formData.get();
    System.out.println("OK: " + data.firstName + " " + data.lastName + " " + data.telephone);
    return ok(NewContact.render(formData));
  }
  
}
