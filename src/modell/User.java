package modell;

public class User {

    private int userid;
    private String username;
    private String password;
    private String role;

    public User(int userid, String username, String password, String role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
     public void setRole(String role) {
        this.role = role;
    }
}
