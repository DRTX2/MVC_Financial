package Models.user;

import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Role> roles;
    
    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
    
    public boolean hasPermission(Permission permission) {
        for (Role role : roles) {
            if (role.getPermissions().contains(permission)) {
                return true;
            }
        }
        return false;
    }
}