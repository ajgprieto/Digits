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
    
    if (UserInfoDB.hasAdmin()) {
      Contact contact1 = new Contact(1L, "Philip", "Johnson", "123-456-7890", "Home");
      Contact contact2 = new Contact(2L, "Jane", "Doe", "477-456-7890", "Work");
      Contact contact3 = new Contact(1L, "Justin", "Verlander", "999-456-8888", "Home");
      Contact contact4 = new Contact(2L, "Gordie", "Howe", "654-456-2345", "Mobile");

      UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
      UserInfoDB.addUserInfo("John Jacob", "jacob@example.com", "password");

      ContactDB.add("smith@example.com", new ContactFormData(contact1));
      ContactDB.add("smith@example.com", new ContactFormData(contact2));
      ContactDB.add("jacob@example.com", new ContactFormData(contact3));
      ContactDB.add("jacob@example.com", new ContactFormData(contact4));
    }
  }

}
