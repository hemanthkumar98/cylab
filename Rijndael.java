import java.security.AlgorithmParameters;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.lang.*;
import java.io.*;
import java.util.Base64;
import javax.*;
import java.*;

public class Rijndael {

    static String plainText = "This is plain text!";

    public static void main(String[] args) throws Exception {
        // Rijndael key
        String secretKey = "RijndaelKey12345678";

        // Salt
        byte[] salt = {
            (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
            (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
        };

        // Iteration count
        int iterationCount = 19;

        // Create key
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount, 256);
        SecretKey secretKey1 =  new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        // Create cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey1);
        AlgorithmParameters params = cipher.getParameters();

        // Get the iv
        byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();

        // Encrypt
        byte[] encryptedTextBytes = cipher.doFinal(plainText.getBytes("UTF-8"));

        // Encode bytes to base64 to get a string
        String encryptedText = new String(Base64.getEncoder().encode(encryptedTextBytes));
        System.out.println("Encrypted Text: " + encryptedText);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secretKey1, new IvParameterSpec(iv));
        byte[] decryptedTextBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptedTextBytes);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}