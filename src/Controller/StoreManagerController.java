package Controller;

import Database.UserDAO;
import modell.User;
import java.util.List;

public class StoreManagerController {

    private UserDAO dao = new UserDAO();

    public void addUser(int id, String name, String pw, String role) {
        dao.addUser(new User(id, name, pw, role));
    }

    public boolean updateUser(int id, String name, String pw, String role) {
        User u = dao.getUserById(id);
        if (u != null) {
            dao.updateUser(new User(id, name, pw, role));
            return true;
        }
        return false;
    }

    public boolean deleteUser(int id) {
        return dao.deleteUser(id);
    }

    public List<User> getUsers() {
        return dao.getAllUsers();
    }
}
