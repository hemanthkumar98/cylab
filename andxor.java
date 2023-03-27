import java.lang.*;
import java.io.*;
import java.util.*;

public class andxor 
{
    public static void main(String[] args) 
    {
        int i;
        String value="Hello World";
        String val=value;
        String va=value;
        int len=value.length();
        for(i=0;i<len;i++)
        {
            value=value+Character.toString((char)(value.charAt(i)&127));
        }
        System.out.println(value); 
       for(i=0;i<=len;i++)
        {
            val=val+Character.toString((char)(val.charAt(i)^127));
        }
        System.out.println(val);
        for(i=0;i<=len;i++)
        {
            va=va+Character.toString((char)(va.charAt(i)|127));
        }
        System.out.println(val);
    }   
}
