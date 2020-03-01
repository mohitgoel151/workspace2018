package leetcode.weekly._173;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nextGreaterElement {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1999999999));
    }

    public static int nextGreaterElement(int n) {
        
        String no = String.valueOf(n);
        int length = no.length();
        
        char[] arr = no.toCharArray();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int index = length-1; index > 0; index--) {
            char current = arr[index];
            char next = arr[index-1];
            
            int curValue = Integer.parseInt(String.valueOf(current));
            int nextValue = Integer.parseInt(String.valueOf(next));
            map.put(curValue, index);
            
            if(nextValue >= curValue) {
                
            } else {
                int replaceWithValue = getJustNextBigger(map, nextValue+1);
                int rIndex = map.get(replaceWithValue);
                arr[index-1] = (char)(replaceWithValue + '0');
                arr[rIndex] = next;
                sort(arr, index);
                return Integer.parseInt(String.valueOf(arr));
                
            }
        }
        return -1;
    }
    
    private static void sort(char[] arr, int sIndex) {
        List<Character> list = new ArrayList<>();
        
        for(int index = sIndex; index < arr.length; index++) {
            list.add(arr[index]);
        }
        Collections.sort(list);
        
        for(int index = 0; index < list.size(); index++) {
            arr[sIndex+index] = list.get(index);
        }
    }
    
    public static int getJustNextBigger(Map<Integer, Integer> map, int val) {
        while(val < 10) {
            Integer index = map.get(val);
            if(index != null) {
                return val;
            }
            val++;
        }
        return -1;
    }
    
}
