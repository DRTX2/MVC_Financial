package Models.user;

import java.util.Arrays;
import java.util.List;

public class AdminRole implements Role {
    private List<Permission> permissions = Arrays.asList(new ReadPermission(), new WritePermission());
    
    @Override
    public String getName() {
        return "ADMIN";
    }
    
    @Override
    public List<Permission> getPermissions() {
        return permissions;
    }
}
