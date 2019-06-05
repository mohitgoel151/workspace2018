package com.mohit.poc.fb;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;

/**
 * Return sum of two numeric string
 * 
 * @author mohgoel
 *
 */
public class FbStringSum {

    public void execute() {
		assertEquals("0.0", calculateSum(".", "."));
	    assertEquals("3.3", calculateSum("3.", ".3"));

        assertEquals("2.7", calculateSum("2.3", "0.4"));
        assertEquals("2.776", calculateSum("2.3", "0.476"));

        assertEquals("3.466", calculateSum("2.99", "0.476"));

        assertEquals("2.0", calculateSum("2.0", "0"));
        assertEquals("224.0", calculateSum("2.0", "222.0"));
        
        assertEquals("224.4", calculateSum("2", "222.4"));
        
        System.out.println("Passed all test cases of " + this.getClass().getSimpleName());
    }

    /**
     * beautify number
     * split numbers before and after fractions
     * Calculate sum of fractional part
     * calculate sum of integral part considering carry forward of fractional part
     * @param num1
     * @param num2
     * @return
     */
    private String calculateSum(String num1, String num2) {

        String bNum1 = beautifyNumber(num1);
        String bNum2 = beautifyNumber(num2);
        
        String[] parts1 = StringUtils.split(bNum1, "\\.");
        String[] parts2 = StringUtils.split(bNum2, "\\.");

        String fractional = addFractionalParts(parts1[1], parts2[1]);
        String bFractional = beautifyNumber(fractional);

        String[] fractionalSum = StringUtils.split(bFractional, ".");

        String tempInt = addIntegralPart(parts1[0], parts2[0]);
        String integralSum = addIntegralPart(tempInt, fractionalSum[0]);

        return integralSum + "." + fractionalSum[1];
    }

    /**
     * Make length of both string equal by appending zero to smaller one
     * @param str1
     * @param str2
     * @return
     */
    private String addFractionalParts(String str1, String str2) {

        StringBuilder builder = new StringBuilder();

        String larger = str1.length() > str2.length() ? str1 : str2;
        String smaller = str1.length() > str2.length() ? str2 : str1;

        smaller = smaller + getZeroOfLength(larger.length() - smaller.length());

        int sum = 0;
        int carry = 0;

        for (int index = larger.length() - 1; index >= 0; index--) {
            sum = Integer.parseInt(String.valueOf(larger.charAt(index))) + Integer.parseInt(String.valueOf(smaller.charAt(index))) + carry;

            carry = sum / 10;
            sum = sum % 10;
            builder.append(sum);
        }

        builder.append(".").append(carry);

        return builder.reverse().toString();
    }

    private String getZeroOfLength(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("0");
        }

        return builder.toString();
    }

    private String addIntegralPart(String str1, String str2) {

        StringBuilder builder = new StringBuilder();

        String larger = str1.length() > str2.length() ? str1 : str2;
        String smaller = str1.length() > str2.length() ? str2 : str1;

        smaller = getZeroOfLength(larger.length() - smaller.length()) + smaller;

        int sum = 0;
        int carry = 0;

        for (int index = larger.length() - 1; index >= 0; index--) {
            sum = Integer.parseInt(String.valueOf(larger.charAt(index))) + Integer.parseInt(String.valueOf(smaller.charAt(index))) + carry;

            carry = sum / 10;
            sum = sum % 10;
            builder.append(sum);
        }

        if (carry > 0) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }
    
    /**
     * Append 0 before and after if there is no valid digit
     * @param input
     * @return
     */
    private String beautifyNumber(String input) {
        StringBuilder builder = new StringBuilder(input);
        if(input.charAt(0) == '.') {
            builder.insert(0, '0');
        }
        if(input.charAt(input.length()-1) == '.') {
            builder.append('0');
        }
        
        if(StringUtils.contains(input, '.') == false) {
            builder.append(".0");
        }

        return builder.toString();
    }

}
