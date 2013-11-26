import models.Contact;
import models.ContactDB;
import models.UserInfoDB;
import play.*;
import views.formdata.ContactFormData;

/**
 * Global class. Provides Contacts that are included on startup.
 * 
 * @author AJ
 * 
 */
public class Global extends GlobalSettings {

  /**
   * Adds the four contacts to the database on startup.
   * 
   * @param app the application.
   */
  public void onStart(Application app) {

    String email = Play.application().configuration().getString("admin.email");
    String password = Play.application().configuration().getString("admin.password");
    
    System.out.println(email + " " + password);
    UserInfoDB.defineAdmin("Admin", email, password);
    
    if (UserInfoDB.hasAdmin() && UserInfoDB.getUser(email).getContacts().isEmpty()) {
      ContactDB.add(email, 
          new ContactFormData(new Contact("Jon", "Smith", "111-111-1111", "Home")));
      ContactDB.add(email, 
          new ContactFormData(new Contact("Jack", "Smith", "222-222-2222", "Work")));
    }
  }

}
