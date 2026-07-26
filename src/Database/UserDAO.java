package Database;

import modell.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void addUser(User u) {
        String sql = "INSERT INTO user VALUES (?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, u.getUserId());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getPassword());
            pst.setString(4, u.getRole());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User u) {
        String sql = "UPDATE user SET username=?, password=?, role=? WHERE userid=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getRole());
            pst.setInt(4, u.getUserId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteUser(int id) {
        String sql = "DELETE FROM user WHERE userid=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new User(
                        rs.getInt("userid"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE userid=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("userid"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }
    public User login(String username, String password) {
    String sql = "SELECT * FROM user WHERE username=? AND password=?";
    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, username);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return new User(
                rs.getInt("userid"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}

