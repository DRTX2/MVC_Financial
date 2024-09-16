package Models.user;

public class WritePermission implements Permission {
    @Override
    public String getName() {
        return "WRITE";
    }
}