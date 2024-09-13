
package Models.user;

public class NormalUser extends User {
    public NormalUser(String username, String email) {
        super(username, email, Role.NORMAL);
    }

    @Override
    public void displayPermissions() {
        System.out.println("Normal user permissions: ");
        for (Permission p : getRole().getPermissions()) {
            System.out.println("- " + p);
        }
    }
}
