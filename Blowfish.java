import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
public class Blowfish {
  public static void main(String[] args) throws Exception {
    String plainText = "Hello World";
    String key = "Bar12345Bar12345"; // 128 bit key
    // Create key and cipher
    Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES");
    // encrypt the text
    cipher.init(Cipher.ENCRYPT_MODE, aesKey);
    byte[] encrypted = cipher.doFinal(plainText.getBytes());
    System.out.println("Encrypted String:" + DatatypeConverter.printBase64Binary(encrypted));
    // decrypt the text
    cipher.init(Cipher.DECRYPT_MODE, aesKey);
    String decrypted = new String(cipher.doFinal(encrypted));
    System.out.println("Decrypted String:" + decrypted);
  }
}