package com.mohit.poc.list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * http://codeanytime.blogspot.com/2015/01/largest-number.html 
 * Given a list of non negative integers, arrange
 * them such that they form the largest number. For example, given [3, 30, 34, 5, 9], the largest formed
 * number is 9534330. Note: The result may be very large, so you need to return a string instead of an
 * integer.
 *
 */
public class LargestNumber {
	
    public static void main(String[] args) {
        LargestNumberSol obj = new LargestNumberSol();
        obj.execute();
        System.out.println("All tc passed " + obj.getClass().getSimpleName());
    }
}

class LargestNumberSol{
	
    public void execute() {

        int[] i1 = { 3, 30, 34, 5, 9 };
        int[] i2 = { 3, 90, 94, 5, 9 };

        assertEquals("9534330", getLargestString(i1));
        
        assertEquals("9949053", getLargestString(i2));

    }

    private String getLargestString(int[] input) {

        // validation

        List<String> numberList = new ArrayList<>();
        for (int no : input) {
            numberList.add(String.valueOf(no));
        }

        Collections.sort(numberList, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2); // Imp : Take care of this ordering
            }
        });

        StringBuilder buffer = new StringBuilder();
        for (String a : numberList) {
            buffer.append(a);
        }
        return buffer.toString();
    }

}
