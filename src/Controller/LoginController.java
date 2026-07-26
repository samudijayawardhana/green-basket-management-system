
package Controller;

import Database.UserDAO;
import modell.User;

public class LoginController {
    
    private UserDAO dao = new UserDAO();
    public User login(String u, String p) {
        return dao.login(u, p);
    }
}

