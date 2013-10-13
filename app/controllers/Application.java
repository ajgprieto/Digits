package controllers;

import play.mvc.Controller;
import play.mvc.Result;
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
  public static Result newcontact() {
    return ok(NewContact.render());
  }
  
}
