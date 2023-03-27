import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class BlowFishCipher {

    public static String encrypt(String key, String data) throws Exception {
        byte[] keyData = key.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static void main(String args[]) throws Exception { 

      String data = "abcdefg";  // Plain text to be encrypted

      String key = "mySecretKey"; // Key used for encryption 

      System.out.println("Original Text: "+data); 

      String encryptedText = encrypt(key, data);   //Encrypting the plain text 

      System.out.println("Encrypted Text: "+encryptedText);   //Printing the encrypted text 
   } 
}