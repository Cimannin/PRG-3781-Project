package bcwellness;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//created this to hash each and every password entered by a user
public class PasswordHash {
    public static String hashPassword(String password) {
        //Used SHA-256 because it takes input like a password, and converts it.
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
    //This is used to make sure the password isnt seen in the database.
}
