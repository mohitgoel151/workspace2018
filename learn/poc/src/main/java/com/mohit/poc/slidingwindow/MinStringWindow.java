package com.mohit.poc.slidingwindow;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class MinStringWindow {

	public static void main(String[] args) {
		MinStringWindowSolution win = new MinStringWindowSolution();
		
		assertEquals("ADOBEC", win.minWindow("ADOBECODEBANC", "OAC"));
		System.out.println("All passed " + win.getClass().getSimpleName());
	}

}

class MinStringWindowSolution {
    public String minWindow(String s, String t) {
        
        if(t == null || s == null) {
            return null;
        }
        
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char aChar : t.toCharArray()) {
            Integer freq = freqMap.getOrDefault(aChar, 0) + 1;
            freqMap.put(aChar, freq);
        }
        
        int front = 0, rear = 0;
        int minSize = Integer.MAX_VALUE;
        int minRear = 0;
        
        while(front < s.length()) {
            
            char frontChar = s.charAt(front);
            Integer freq = freqMap.get(frontChar);
            
            if(freq != null) {
                freqMap.put(frontChar, freq-1);
                        
                if(containsAllChars(freqMap)) {
                    while(containsAllChars(freqMap)) {
                        char rearChar = s.charAt(rear);
                        Integer rearCharFreq = freqMap.get(rearChar);
                        if(rearCharFreq != null) {
                            freqMap.put(rearChar, rearCharFreq+1);
                        }
                        rear++;
                    }

                    rear--;
                    char rearChar = s.charAt(rear);
                    Integer rearCharFreq = freqMap.get(rearChar);
                    freqMap.put(rearChar, rearCharFreq-1);
                    
                    if(front-rear+1 < minSize) {
                        minSize = front-rear+1;
                        minRear = rear;
                    }
                }
            }

            front++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(minRear, minRear+minSize);
    }
    
    private boolean containsAllChars(Map<Character, Integer> freqMap) {
        for(int freqValue : freqMap.values()) {
            if(freqValue > 0) {
                return false;
            }
        }
        return true;
    }
}