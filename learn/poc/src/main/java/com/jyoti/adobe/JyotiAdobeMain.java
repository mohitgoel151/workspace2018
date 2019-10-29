package com.jyoti.adobe;

import java.util.Scanner;

public class JyotiAdobeMain {
    
    @SuppressWarnings("resource")
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        String inputStr = scanner.next();
        scanner.close();
        int inputLength = inputStr.length();
        char[] charArray = new char[inputLength];

        for (int i = 0; i < inputLength / 2; i++) {
            charArray[i] = inputStr.charAt(inputLength - i - 1);
            charArray[inputLength - i - 1] = inputStr.charAt(i);
        }

        String str = charArray.toString();

        String[] words = str.split(" ");
        String reversedString = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }
        System.out.println(reversedString.trim());
    }

//    public static void main(String args[]) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//
//        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
//        String inputStr = scanner.next();
//        scanner.close();
//        
//        
//
//        int inputLength = inputStr.length();
//        char[] charArray = new char[inputLength];
//
//        for (int i = 0; i < inputLength / 2; i++) {
//            charArray[i] = inputStr.charAt(inputLength - i - 1);
//            charArray[inputLength - i - 1] = inputStr.charAt(i);
//        }
//
//        String str = new String(charArray);
//
//        String[] words = str.split(" ");
//        String reversedString = "";
//        for (int i = 0; i < words.length; i++) {
//            String word = words[i];
//            String reverseWord = "";
//            for (int j = word.length() - 1; j >= 0; j--) {
//                reverseWord = reverseWord + word.charAt(j);
//            }
//            reversedString = reversedString + reverseWord + " ";
//        }
//        System.out.println(reversedString.trim());
//    }

}
