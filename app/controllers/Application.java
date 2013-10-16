package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns home, a page that contains sample contacts.
   * 
   * @return The Home.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns newcontact, a page that simulates an add contact page.
   * 
   * @param id the id of the Contact
   * 
   * @return The NewContact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render(formData));
  }
  
  /**
   * Deletes the contact from the contact list.
   * 
   * @param id the id of the contact to be deleted.
   * 
   * @return the new contact list after deletion.
   */
  public static Result deleteContact(long id) {
    ContactDB.delete(id);
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Posts the contact info to the Play console and adds it to the contact database.
   * 
   * @return contact info to the play console.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("Errors Found");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.add(data);
      System.out.println("OK: " + data.firstName + " " + data.lastName + " " + data.telephone);
      return ok(NewContact.render(formData));
    }
  }

}
