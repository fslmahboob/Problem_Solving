
/**
 * Assignment 2: Caesar Cipher
 * 
 * M. Faisal Mahboob
 * 16/03/2024
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipher {
    public String encrypt(String input, int key){
        // Make a StringBuilder with encrypted
        StringBuilder encrypted = new StringBuilder(input);
        // Store all the alphabets
        String alphabet_u = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet_l = "abcdefghijklmnopqrstuvwxyz";
        // Compute the shifted alphabet for uppercase and lowercase       
        String shiftedAlphabet_u = alphabet_u.substring(key) + alphabet_u.substring(0,key);
        String shiftedAlphabet_l = alphabet_l.substring(key) + alphabet_l.substring(0,key);
        // Initialise indices
        int idx = 0;
        // Count from 0 to < length of encrypted
        for (int i=0; i < encrypted.length(); i++){          
            // Look at the ith character of encrypted -> currChar
            char currChar = encrypted.charAt(i);
            // Debugging
            //System.out.println("currChar: " + currChar);
            //System.out.println("Test of lowercase: " + Character.isLowerCase(currChar));
            // Check uppercase or lowercase
            if (Character.isLowerCase(currChar)){
                // Find the index of currChar in the alphabet for lowercase
                idx = alphabet_l.indexOf(currChar);
                // Debugging
                //System.out.println("idx_L: " + idx);
                char newChar = shiftedAlphabet_l.charAt(idx);
                //Debugging
                //System.out.println("newChar_L: " + newChar);
                encrypted.setCharAt(i, newChar);
            } else if (Character.isUpperCase(currChar)) {
                // Find the index of currChar in the alphabet for uppercase
                idx = alphabet_u.indexOf(currChar);
                // Debugging
                //System.out.println("idx_U: " + idx);
                char newChar = shiftedAlphabet_u.charAt(idx);
                //Debugging
                //System.out.println("newChar_U: " + newChar);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            // Otherwise: do nothing
        }
        // Answer is now the string inside of encrypted
        return encrypted.toString();
    }
    
    public void testCaesar(){
        // CASE 1
        //FileResource fr1 = new FileResource();
        //String message = fr1.asString().trim();
        //int key = 23;
        //String encrypted = encrypt(message, key);
        //System.out.println("key is " + key + "\n" + encrypted);
        
        // CASE 2
        FileResource fr2 = new FileResource();
        String message = fr2.asString().trim();
        int key = 17;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        // Make a StringBuilder with input
        StringBuilder encrypted = new StringBuilder(input);
        // Store all the alphabets
        String alphabet_u = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet_l = "abcdefghijklmnopqrstuvwxyz";
        // Compute the shifted alphabet for uppercase and lowercase letters for each key
        String shiftedAlphabet_u1 = alphabet_u.substring(key1) + alphabet_u.substring(0,key1);
        String shiftedAlphabet_l1 = alphabet_l.substring(key1) + alphabet_l.substring(0,key1);
        String shiftedAlphabet_u2 = alphabet_u.substring(key2) + alphabet_u.substring(0,key2);
        String shiftedAlphabet_l2 = alphabet_l.substring(key2) + alphabet_l.substring(0,key2);
        // Initialise indices
        int idx = 0;
        // Loop through each character in the string
        for (int i = 0; i < encrypted.length(); i++){
            // For key 1,
            if (i % 2 == 0){
                // Look at ith character in encrypted for even indices
                char currChar = encrypted.charAt(i);
                if (Character.isLowerCase(currChar)){
                    idx = alphabet_l.indexOf(currChar);
                    char newChar = shiftedAlphabet_l1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                } else if (Character.isUpperCase(currChar)){
                    idx = alphabet_u.indexOf(currChar);
                    char newChar = shiftedAlphabet_u1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                // Look at ith character in encrypted for odd indices
                char currChar = encrypted.charAt(i);
                if (Character.isLowerCase(currChar)){
                    idx = alphabet_l.indexOf(currChar);
                    char newChar = shiftedAlphabet_l2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                } else if (Character.isUpperCase(currChar)){
                    idx = alphabet_u.indexOf(currChar);
                    char newChar = shiftedAlphabet_u2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys(){
        String message = "First Legion";
        int key1 = 23;
        int key2 = 17;
        String result = encryptTwoKeys(message, key1, key2);
        System.out.println("Encrypted: " + result);
    }
}