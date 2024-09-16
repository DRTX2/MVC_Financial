package Services.user;

import Models.user.Permission;
import Models.user.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    // Maneja la creación, edición y búsqueda de usuarios, así como la verificación de permisos./
    private List<User> users = new ArrayList<>();
    
    public void addUser(User user) {
        users.add(user);
    }
    
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public boolean checkPermission(String username, Permission permission) {
        User user = getUser(username);
        if (user != null) {
            return user.hasPermission(permission);
        }
        return false;
    }
}
