package Models.user;

public class ReadPermission implements Permission {
    @Override
    public String getName() {
        return "READ";
    }
}
