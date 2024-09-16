package Models.user;

import java.util.List;

public interface Role {
    String getName();
    List<Permission> getPermissions();
}