Import the necessary libraries: java.math.BigInteger and java.security.MessageDigest.

Define a class called MD5.

Define a public static method called getMd5 that takes one String argument: input.

The method should throw a NoSuchAlgorithmException.

Call the getInstance() method of the MessageDigest class, passing the string "MD5" as an argument. Store the result in a MessageDigest object called md.

Call the digest() method of the md object, passing the input String converted to bytes using the getBytes() method as an argument. Store the result in a byte array called messageDigest.

Convert the messageDigest byte array to a BigInteger using the constructor that takes two arguments: 1 and messageDigest. Store the result in a BigInteger called no.

Convert the no BigInteger to a String using the toString() method with an argument of 16. Store the result in a String called hashtext.

If the length of hashtext is less than 32, prepend "0" to hashtext until its length is 32.

Return the hashtext String.

Define a public static void main() method that takes no arguments and throws a NoSuchAlgorithmException.

Create a String variable called s and set it to "JNTUK".

Call the getMd5() method with the s variable as an argument and store the result in a String variable called hashcode.

Print out the hashcode using System.out.println().






Here is the algorithm for the BlowFishCipher Java program:

Import the necessary libraries: javax.crypto.Cipher, javax.crypto.spec.SecretKeySpec, and java.util.Base64.

Define a class called BlowFishCipher.

Define a public static method called encrypt that takes two String arguments: key and data. The method should throw an Exception.

Convert the key String to a byte array using the getBytes() method and store the result in a byte array called keyData.

Create a new instance of the SecretKeySpec class, passing the keyData byte array and the string "Blowfish" as arguments. Store the result in a SecretKeySpec object called secretKey.

Create a new instance of the Cipher class, calling the getInstance() method and passing the string "Blowfish" as an argument. Store the result in a Cipher object called cipher.

Initialize the cipher object for encryption mode by calling the init() method with Cipher.ENCRYPT_MODE and the secretKey object as arguments.

Convert the data String to a byte array using the getBytes() method and store the result in a byte array called dataBytes.

Encrypt the dataBytes byte array by calling the doFinal() method on the cipher object and passing the dataBytes byte array as an argument. Store the result in a byte array called encryptedData.

Convert the encryptedData byte array to a Base64-encoded String using the getEncoder() method of the Base64 class and store the result in a String called encryptedText.

Return the encryptedText String.

Define a public static void main() method that takes no arguments and throws an Exception.

Create a String variable called data and set it to "abcdefg".

Create a String variable called key and set it to "mySecretKey".

Print out the original text using System.out.println().

Encrypt the original text by calling the encrypt() method with the key and data arguments and store the result in a String variable called encryptedText.

Print out the encrypted text using System.out.println().