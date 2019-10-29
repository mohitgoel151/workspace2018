package com.mohit.poc.fb;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

/**
 * 
 * Smallest substring which contains "n" number of distinct characters
 *
 */
public class FbSlidingWindow {

    public void execute() {

        assertEquals("a", getSubstring("aabb", 1));
        assertEquals("ab", getSubstring("aabb", 2));
        assertEquals("aabb", getSubstring("aabb", 3));
        assertEquals("abc", getSubstring("abccddeef", 3));

        assertEquals("abbc", getSubstring("aabbccddd", 3));
        assertEquals("baad", getSubstring("aabbaaddd", 3));
        assertEquals("dxy", getSubstring("aabbaadddxyz", 3));
        assertEquals("adddxyz", getSubstring("aabbaadddxyz", 5));

        try {
            assertEquals("ddf", getSubstring("dfg", 0));
            Assert.fail("Should have thrown an exception");
        } catch (Exception e) {
            String expectedMessage = "invalid";
            Assert.assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
        }
    }

    private String getSubstring(String input, int threshold) {

        if (StringUtils.isBlank(input) || threshold < 1) {
            throw new IllegalArgumentException("invalid");
        }

        int backPtr = 0;
        String result = input;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int aheadIndex = 0; aheadIndex < input.length(); aheadIndex++) {

            Character aChar = input.charAt(aheadIndex);
            Integer count = freqMap.get(aChar);

            if (count != null) {
                freqMap.put(aChar, count + 1);
            } else {
                // Put new char to map
                freqMap.put(aChar, 1);
                int size = freqMap.size();

                if (size < threshold) {
                    // continue
                } else if (size == threshold) {
                    backPtr = moveFwd(input, backPtr, threshold, freqMap);
                    if (result.length() > (aheadIndex + 1 - backPtr)) {
                        result = input.substring(backPtr, aheadIndex + 1);
                    }

                } else {
                    // remove one character from map and go to last char index of next new
                    backPtr = removeCharacter(freqMap, input, backPtr, threshold);
                    if (result.length() > (aheadIndex + 1 - backPtr)) {
                        result = input.substring(backPtr, aheadIndex + 1);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Remove one character by forwarding backPointer index now move forward till last occurrence of next
     * character
     * 
     * @param map
     * @param input
     * @param end
     * @param threshold
     * @return
     */
    private int removeCharacter(Map<Character, Integer> map, String input, int end, int threshold) {
        int result = end;

        for (int i = end; i < input.length(); i++) {
            Character aChar = input.charAt(i);

            Integer count = map.get(aChar);
            if (count == 1) {
                map.remove(aChar);
                result = i + 1;
                break;
            } else {
                map.put(aChar, count - 1);
            }
        }
        return moveFwd(input, result, threshold, map);
    }

    /**
     * Move backPointer forward till the count of char at last index is one
     * 
     * @param input
     * @param backPtr
     * @param threshold
     * @param map
     * @return
     */
    private int moveFwd(String input, int backPtr, int threshold, Map<Character, Integer> map) {
        int result = backPtr;

        for (int i = result; i < input.length() - 1; i++) {

            Character aChar = input.charAt(i);
            Integer count = map.get(aChar);

            if (count == 1) {
                result = i;
                break;
            } else {
                map.put(aChar, count - 1);
            }
        }
        return result;
    }

}
