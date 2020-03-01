package leetcode.biweekly._16;

import java.util.ArrayList;
import java.util.List;

public class Seq {

    public static void main(String[] args) {
        
        System.out.println(Math.ceil(8/3));
        
        
//        System.out.println(sequentialDigits(100, 300));

    }
    
    public static List<Integer> sequentialDigits(int low, int high) {
        if(low > high) {
            return new ArrayList<Integer>();
        }
        
        int firstDigitOfLow = getFirstDigit(low);
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = firstDigitOfLow; i < 10; i++) {
            int next = i;
            int number = i;
            
            while(number <= high) {
                if(number >= low) {
                   result.add(number); 
                }
                next++;
                if(next == 10) {
                    break;
                }
                number = number*10 + next;
            }
        }
        return result;
    }
    
    private static int getFirstDigit(int number) {
        while(number >= 10) {
            number /= 10;
        }
        return number;
    }

}
