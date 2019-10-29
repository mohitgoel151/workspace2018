package com.mohit.zzzzz;

import static org.junit.Assert.assertEquals;

public class FbbinaryStringAddnRevise {

    public void execute() {
        
        assertEquals(getSum("1111", "111"), "10110");
        assertEquals(getSum("1111", "110"), "10101");
        assertEquals(getSum("1101", "100"), "10001");
        assertEquals(getSum("1100011", "10"), "1100101");
        System.out.println("Passed all test of class = " + this.getClass().getSimpleName());
    }

    private String getSum(String input1, String input2) {
        
        if(input1 == null || input2 == null) {
            throw new IllegalArgumentException("");
        }
        
        int maxLength = Math.max(input1.length(), input2.length());
        
        String s1 = makeStringofLength(input1, maxLength);
        String s2 = makeStringofLength(input2, maxLength);
        
        int carry = 0;
        
        StringBuffer result = new StringBuffer();
        
        for (int i = 0; i < maxLength; i++) {
            int sum = carry + Integer.parseInt(String.valueOf(s1.charAt(i))) + Integer.parseInt(String.valueOf(s2.charAt(i))); 
            if(sum % 2 == 1) {
                result.append("1");
            } else {
                result.append("0");
            }
            carry = sum/2;
        }
        
        if(carry == 1) {
            result.append(1);
        }
        
        return result.reverse().toString();
    }
    
    private String makeStringofLength(String str, int length) {
        StringBuffer buffer = new StringBuffer();
        
        if(str.length() != length) {
            int shortage = length - str.length();
            for(int i = 0; i < shortage; i++) {
                buffer.append("0");
            }
            buffer.append(str);
            
        } else {
            buffer.append(str);
        }
        return buffer.reverse().toString();
    }
    

}
