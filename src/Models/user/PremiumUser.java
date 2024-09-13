package Models.user;

public class PremiumUser extends User {
    public PremiumUser(String username, String email) {
        super(username, email, Role.PREMIUM);
    }

    @Override
    public void displayPermissions() {
        System.out.println("Premium user permissions: ");
        for (Permission p : getRole().getPermissions()) {
            System.out.println("- " + p);
        }
    }
}