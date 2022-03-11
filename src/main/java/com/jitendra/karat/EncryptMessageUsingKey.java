package com.jitendra.karat;
/* You decide to create a substitution cipher. The cipher alphabet is based on a key shared amongst those of your friends who don't mind spoilers.

Suppose the key is:
"The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!".

We use only the unique letters in this key to set the order of the characters in the substitution table.

T H E Q U I C K O N Y X G B L R A S W D J M P V Z F

(spaces added for readability)

We then align it with the regular alphabet:
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
T H E Q U I C K O N Y X G B L R A S W D J M P V Z F

Which gives us the substitution mapping: A becomes T, B becomes H, C becomes E, etc.

Write a function that takes a key and a string and encrypts the string with the key.

Example:
key = "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!"
encrypt("It was all a dream.", key) -> "Od ptw txx t qsutg."
encrypt("Would you kindly?", key) -> "Pljxq zlj yobqxz?"

Complexity analysis:

m: The length of the message
k: The length of the key */


import java.util.*;

public class EncryptMessageUsingKey {
    public static void main(String[] argv) {
        String key = "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!";
        convertKey(key);
        String message = "It was all a dream.";
        String message2 = "Would you kindly?";
    }


    public static String convertKey(String key){
        key = key.replaceAll(" ","");
        key = key.replaceAll("==}--------","");
        key = key.replaceAll(",","");
        key = key.replaceAll("!","");
        key = key.replaceAll("1","");

        key = key.toUpperCase();
        System.out.println("key = " + key);

        Set<Character> charSet = new LinkedHashSet<>();
        for(int i=0; i<key.length();i++){
            charSet.add(key.charAt(i));
        }

        Map<Character, Character> charMap = new HashMap<>();
        for(Character c : charSet){

        }

        System.out.println("set = " + charSet);
        return key;
    }


    public static String returnMsg(String msg, int rows, int cols){
        //char array
        char[] charMsg = msg.toCharArray();
        StringBuilder sb = new StringBuilder();

//     System.out.println(msg + ":" + charMsg.length);
        for(int i=0; i< cols; i++){
            for(int j=i; j<charMsg.length; j++){
//         System.out.println(j + ":" + charMsg[j]);
                sb = sb.append(String.valueOf(charMsg[j]));
                j = j + cols-1;
            }
        }

//     System.out.println("sb = " + sb.toString());
        return sb.toString();
    }
}
