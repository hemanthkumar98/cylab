import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

    public static void main(String[] args) {
        String input = "JNTUK";
        String output = sha1(input);
        System.out.println("SHA-1 hash of \"" + input + "\" is:");
        System.out.println(output);
    }

    public static String sha1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
