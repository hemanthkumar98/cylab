import java.lang.*;
import java.io.*;
import java.util.*;

class xor {
    public static void main(String[] args) 
    {
        int i;
        String value="Hello World";
        int len=value.length();
        for(i=0;i<len;i++)
        {
            value=value+Character.toString((char)(value.charAt(i)^127));
        }
        System.out.println(value); 
    }
}
