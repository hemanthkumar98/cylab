import java.lang.*;
import java.io.*;
import java.util.*;
public class SubstitutionCipher 
{ 
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String a = "abcdefghijklmnopqrstuvwxys";
        String b = "zxywvustrqponmlkjihgfedcba";
        System.out.println("Enter String:");
        String str = br.readLine();
        String encrypt = "";
        char c;
        for(int i=0;i<str.length();i++)
        {
            c = str.charAt(i);
            int j = a.indexOf(c);
            encrypt = encrypt+b.charAt(j);
        }
        System.out.println("The encrypted data is:"+encrypt);
        }
}