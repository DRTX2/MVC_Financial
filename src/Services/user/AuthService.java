package Services.user;

    //  Maneja la autenticación de usuarios, verificando credenciales y rol
import Models.user.User;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.EncryptionUtil;

public class AuthService {
    private UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public boolean login(User user, String password) {
        try {
            /*
            User user = userService.findUserByUsername(user);
            if (user != null && EncryptionUtil.verifyPassword(password, user.getPassword())) {
                // Store user session or token if needed
                return true;
            }
            */
            return false;
//        } catch (NoSuchAlgorithmException ex) {
          } catch (Exception ex) {

            Logger.getLogger(AuthService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void logout() {
        // Clear session/token
    }
}