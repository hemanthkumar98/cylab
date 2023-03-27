/*import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
*/
import java.lang.*;
import java.io.*;
import java.security.*;
import javax.*;

public class DESExample {
 
    public static void main(String[] args) {
        //Initialize the plain text
        String plainText = "JNTUK";
 
        //Initialize the key
        String key = "ThisIsAKey";
 
        //Encrypt the plain text
        String cipherText = encrypt(plainText, key);
 
        //Print the encrypted text
        System.out.println("Plain Text : " + plainText);
        System.out.println("Cipher Text : " + cipherText);
 
        //Decrypt the encrypted text
        String decryptedText = decrypt(cipherText, key);
 
        //Print the decrypted text
        System.out.println("Decrypted Text : " + decryptedText);
    }
 
    public static String encrypt(String plainText, String key) {
        //Initialize the cipher text
        String cipherText = "";
 
        //Iterate over each character in the plain text
        for (int i = 0; i < plainText.length(); i++) {
            //Get the plain text character
            char plainTextChar = plainText.charAt(i);
 
            //Get the key character
            char keyChar = key.charAt(i % key.length());
 
            //Encrypt the character
            char cipherTextChar = (char) (plainTextChar ^ keyChar);
 
            //Append the encrypted character
            cipherText += cipherTextChar;
        }
 
        return cipherText;
    }
 
    public static String decrypt(String cipherText, String key) {
        //Initialize the plain text
        String plainText = "";
 
        //Iterate over each character in the cipher text
        for (int i = 0; i < cipherText.length(); i++) {
            //Get the cipher text character
            char cipherTextChar = cipherText.charAt(i);
 
            //Get the key character
            char keyChar = key.charAt(i % key.length());
 
            //Decrypt the character
            char plainTextChar = (char) (cipherTextChar ^ keyChar);
 
            //Append the decrypted character
            plainText += plainTextChar;
        }
 
        return plainText;
    }
}