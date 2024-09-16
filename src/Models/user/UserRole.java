package Models.user;

import java.util.Collections;
import java.util.List;

public class UserRole implements Role {
    private List<Permission> permissions = Collections.singletonList(new ReadPermission());
    
    @Override
    public String getName() {
        return "USER";
    }
    
    @Override
    public List<Permission> getPermissions() {
        return permissions;
    }
}