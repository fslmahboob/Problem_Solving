
/**
 * Assignment 1: Word PLay
 * 
 * M. Faisal Mahboob
 * 16/03/2024
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WordPlay {
    public boolean isVowel (char ch){
        char ch_new = Character.toLowerCase (ch);
    if ((ch_new == 'a') || (ch_new == 'e') || (ch_new == 'i') || (ch_new == 'o') || (ch_new == 'u')){
            return true;
        } else {
            return false;
        }
    }
    
    public void testisVowel(){
        char ch = 'e';
        boolean a = isVowel(ch);
        System.out.println(a);
        
        ch = 'F';
        boolean b = isVowel(ch);
        System.out.println(b);
    }
    
    public String replaceVowels(String phrase, char ch){
        // Make a StringBuilder with phrase
        StringBuilder s_p =  new StringBuilder(phrase);
        
        for (int i = 0; i < phrase.length(); i++){
            // Loop through each character in the string
            char currChar = phrase.charAt(i);
            // Check if character is uppercase or lowercase
            if (Character.isLowerCase(currChar)){
                if (isVowel(currChar)){
                    // Replace vowel with ch
                    char newChar = ch;
                    // Replace the ith character of phrase with newChar
                    s_p.setCharAt(i, newChar);
                }
                } else {
                    // Convert to lowercase before using isVowel method
                    char newChar = Character.toLowerCase(currChar);
                    if (isVowel(newChar)){
                        // Replace vowel with ch
                        newChar = ch;
                        // Replace the ith character of phrase with newChar
                        s_p.setCharAt(i, newChar);
                    }
                }
            // Otherwise: do nothing
            }
        // Answer is String inside of s_p
        return s_p.toString();
    }
    
    public void testreplaceVowels(){
        String a = "Hello World";
        char b = '*';
        String c = replaceVowels(a, b);
        System.out.println(c);
        
        a = "fFaiSal Is EelopU";
        b = '^';
        c = replaceVowels(a, b);
        System.out.println(c);
    }
    
    public String emphasize(String phrase, char ch){
        // Create StringBuilder for string slicing
        StringBuilder s_p = new StringBuilder(phrase);
        
        // Make ch and phrase to lowercases
        String new_phrase = phrase.toLowerCase();
        ch = Character.toLowerCase(ch);
        
        // Initialise index to zero for loop
        int currIndex = 0;
        
        // Loop through each character in string
        for (int i=0; i < phrase.length(); i++){
            // Make sure i doesn't exceed length for indexOf method
            if ((i+1) < phrase.length()){
                // Find ch in phrase
                currIndex = new_phrase.indexOf(ch, i+1);
            } else {
                currIndex = new_phrase.indexOf(ch, i);
            }

            // Check if i is odd
            if ((currIndex+1) % 2 != 0){
                // Replace nextIndexth character with * since odd number location
                s_p.setCharAt(currIndex, '*');
            } else {
                // Replace ith characte with + since even number location
                s_p.setCharAt(currIndex, '+'); 
            }
        }
        return s_p.toString();
    }
    
    public void testemphasize(){
        String phrase = "Mary Bella Abracadabra";
        char ch = 'a';
        String result = emphasize(phrase, ch);
        System.out.println(result);
        
        phrase = "dna ctgaaactga";
        ch = 'a';
        result = emphasize(phrase, ch);
        System.out.println(result);
    }
}
