package com.mohit.zalando;

public class ASol2 {

    public static void main(String[] args) {
        
        
        String output = solution(14, 6);
        System.out.println(output);

    }
    
    public static String solution(int A, int B) {
        int totalSize = A+B; 
        char[] result = new char[totalSize];
        
        int minCount = (A < B) ? A : B;
        int maxCount = (A < B) ? B : A;
        char minCountChar = (A < B) ? 'a' : 'b';
        char maxCountChar = (A < B) ? 'b' : 'a';
        
        int capping = totalSize / (minCount + 1);
        
        int temp = 0;
        int maxCharUsed = 0;
        int minCharUsed = 0;
        for (int i = 0; i < result.length; i++) {
            
            if(temp == capping) {
                result[i] = minCountChar;
                minCharUsed++;
                temp = 0;
            } else {
                if(maxCharUsed < maxCount) {
                    result[i] = maxCountChar;
                    maxCharUsed++;
                    temp++; 
                } else {
                    result[i] = minCountChar;
                    minCharUsed++;
                }
            }
            
        }
        return new String(result);
    }

}
