import java.io.*;
import java.security.*;
import javax.crypto.*;

public class BlowFishAlgorithm {
 
    public static void main(String[] args) throws Exception {
        
        String plaintext = "Hemanthkumar";
        String key = "ThisIsMyKey";
 
        // Generate a secret key
        Key secretkey = generateKey(key);
 
        // Encrypt the data
        byte[] ciphertext = encrypt(plaintext, secretkey);
 
        // Decrypt the data
        String decryptedtext = decrypt(ciphertext, secretkey);
 
        System.out.println("The plaintext is: " + plaintext);
        System.out.println("The ciphertext is: " + ciphertext);
        System.out.println("The decryptedtext is: " + decryptedtext);
    }
 
    public static Key generateKey(String key) throws Exception {
        KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
        keygenerator.init(new SecureRandom(key.getBytes()));
        SecretKey secretkey = keygenerator.generateKey();
        return secretkey;
    }
 
    public static byte[] encrypt(String plaintext, Key secretkey) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return ciphertext;
    }
 
    public static String decrypt(byte[] ciphertext, Key secretkey) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretkey);
        byte[] plaintext = cipher.doFinal(ciphertext);
        return new String(plaintext);
    }
}