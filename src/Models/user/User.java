package Models.user;

public abstract class User {
    private String username;
    private String email;
    private Role role;

    public User(String username, String email, Role role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public abstract void displayPermissions();
}
