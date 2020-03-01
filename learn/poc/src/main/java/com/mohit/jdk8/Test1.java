package com.mohit.jdk8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        
        String a = "abcde";
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char aChar : a.toCharArray()) {
            map.merge(aChar, 1, Integer::sum);
        }
        
        System.out.println(a.substring(0, a.length()));
        
        
        
        int l = "abccba".chars().mapToObj(e->(char)e).collect(Collectors.toSet()).size();
        System.out.println(l);
       

    }

}
