import java.io.*;
import java.util.*;
public class CeaserCipher
{
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException
    {
        System.out.print("Enter string:\n");
        String str = br.readLine();
        System.out.println("Enter Key value:");
        int key = sc.nextInt();
        String encrypted = encrypt(str, key);
        System.out.println("Encrypted String is:"+encrypted);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted String is:"+decrypted);
        System.out.println("\n");
    }
    public static String encrypt(String str, int key)
    {
        String encrypted = "";
        for(int i=0; i<str.length();i++)
        {
            int c = str.charAt(i);
            if(Character.isUpperCase(c))
            {
                c = c+(key%26);
                if(c<'A')
                c = c+26;
            }
            else if(Character.isLowerCase(c))
            {
                c = c+(key%26);
                if(c<'a')
                c = c+26;
            }
            encrypted += (char)c;
        }
        return encrypted;
    }
     public static String decrypt(String str, int key)
    {
        String decrypted = "";
        for(int i=0; i<str.length();i++)
        {
            int c = str.charAt(i);
            if(Character.isUpperCase(c))
            {
                c = c-(key%26);
                if(c<'A')
                c = c+26;
            }
            else if(Character.isLowerCase(c))
            {
                c = c-(key%26);
                if(c<'a')
                c = c+26;
            }
            decrypted += (char)c;
        }
        return decrypted;
    }
}
