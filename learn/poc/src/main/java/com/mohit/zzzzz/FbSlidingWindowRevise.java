package com.mohit.zzzzz;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class FbSlidingWindowRevise {

    public void execute() {

        assertEquals("a", getSubstring("aabb", 1));
        assertEquals("ab", getSubstring("aabb", 2));
        assertEquals("aabb", getSubstring("aabb", 3));

        assertEquals("abbc", getSubstring("aabbccddd", 3));
        assertEquals("baad", getSubstring("aabbaaddd", 3));
        assertEquals("dxy", getSubstring("aabbaadddxyz", 3));
        assertEquals("adddxyz", getSubstring("aabbaadddxyz", 5));
        assertEquals("abc", getSubstring("abccddeef", 3));
        System.out.println("Passed all test of class = " + this.getClass().getSimpleName());
        
    }

    private String getSubstring(String input, int uniqueChars) {
        
        if(input == null || input.length() == 0 || uniqueChars < 1) {
            throw new IllegalArgumentException("");
        }
        
        Map<Character, Integer> freqMap = new HashMap<>();
        
        int ahead = 0, behind = 0;
        
        String smallest = input;
        
        for (; ahead < input.length(); ahead++) {
            
            //add char to map
            Character newChar = input.charAt(ahead);
            Integer tempCount = freqMap.get(newChar);
            if(tempCount == null) {
                tempCount = 0;
            }
            tempCount++;
            freqMap.put(newChar, tempCount);
                
            //Possibilities 
            //1. map size is still less
            //2. Equal
            //3. Greater
            if (freqMap.size() < uniqueChars) {
                continue;
            } else if(uniqueChars == freqMap.size()) {
                //move behind pointer ahead to maintain count
                behind = moveAhead(ahead, behind, input, freqMap);
                
                if(smallest.length() > input.substring(behind, ahead+1).length()) {
                    smallest = input.substring(behind, ahead+1);
                }
            } else {
                //move ahead to remove one char from map
                behind = removeOneChar(ahead, behind, input, freqMap);
                
                if(smallest.length() > input.substring(behind, ahead+1).length()) {
                    smallest = input.substring(behind, ahead+1);
                }
            }
        }
        
        return smallest;
    }

    private int moveAhead(int ahead, int behind, String input, Map<Character, Integer> freqMap) {
        
        while(behind <= ahead) {
            Character lastChar = input.charAt(behind);
            Integer count = freqMap.get(lastChar);
            
            if(count == 1) {
                return behind;
            } else {
                freqMap.put(lastChar, count-1);
            }
            behind++;
        }
        return behind;
    }
    
    private int removeOneChar(int ahead, int behind, String input, Map<Character, Integer> freqMap) {
        
        while(behind <= ahead) {
            Character lastChar = input.charAt(behind);
            Integer count = freqMap.get(lastChar);
            
            if(count == 1) {
                freqMap.remove(lastChar);
                return moveAhead(ahead, behind+1, input, freqMap);
            } else {
                freqMap.put(lastChar, count-1);
            }
            behind++;
        }
        
        return 0;
    }

}
