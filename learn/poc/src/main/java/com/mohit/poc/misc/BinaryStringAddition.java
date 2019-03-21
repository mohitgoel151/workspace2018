package com.mohit.poc.misc;

import static org.junit.Assert.*;

public class BinaryStringAddition {

    public void execute() {
        assertEquals(getSum("1111", "111"), "10110");
        assertEquals(getSum("1111", "110"), "10101");
        assertEquals(getSum("1101", "100"), "10001");
        assertEquals(getSum("1100011", "10"), "1100101");

        assertEquals(getSumWithBitWise("1111", "111"), "10110");
        assertEquals(getSumWithBitWise("1111", "110"), "10101");
        assertEquals(getSumWithBitWise("1101", "100"), "10001");
        assertEquals(getSumWithBitWise("1100011", "10"), "1100101");

        // Failure case
        assertEquals(getSumWithBitWise("1100011", "10"), "1100100");
    }

    private String getSumWithBitWise(String s1, String s2) {

        if (s1 == null || s2 == null) {
            throw new RuntimeException("");
        }

        int l1 = s1.length();
        int l2 = s2.length();

        int maxLength = Math.max(l1, l2);

        int carry = 0;
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < maxLength; i++) {

            int n1 = (l1 > i) ? Integer.parseInt(String.valueOf(s1.charAt(l1 - i - 1))) : 0;
            int n2 = (l2 > i) ? Integer.parseInt(String.valueOf(s2.charAt(l2 - i - 1))) : 0;

            int sum = (n1 ^ n2) ^ carry;
            carry = (n1 & n2) | (n1 & carry) | (n2 & carry);
            result.append(sum);

        }
        if (carry == 1) {
            result.append("1");
        }

        return result.reverse().toString();
    }

    private String getSum(String s1, String s2) {

        if (s1 == null || s2 == null) {
            throw new RuntimeException("");
        }

        int l1 = s1.length();
        int l2 = s2.length();

        int maxLength = Math.max(l1, l2);

        int carry = 0;
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < maxLength; i++) {

            int n1 = (l1 > i) ? Integer.parseInt(String.valueOf(s1.charAt(l1 - i - 1))) : 0;
            int n2 = (l2 > i) ? Integer.parseInt(String.valueOf(s2.charAt(l2 - i - 1))) : 0;

            int tempSum = n1 + n2 + carry;

            if (tempSum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }

            int sum = tempSum % 2;

            result.append(String.valueOf(sum));

        }
        if (carry == 1) {
            result.append("1");
        }

        return result.reverse().toString();
    }

}
