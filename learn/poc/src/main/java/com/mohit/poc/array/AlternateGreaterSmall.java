package com.mohit.poc.array;

import java.util.Arrays;

/**
 * x = [8, 4, 9, 8, 7, 3, 7, 1, 2, 6]
one possible valid output would be:
x = [7, 8, 1, 6, 3, 4, 2, 9, 7, 8]
     1, 9, 2, 8, 3, 8, 4, 7, 6, 7 
 * 
 * x0 <= x1, x1 >= x2, x2 <= x3, x3 >= x4
 *
 */
public class AlternateGreaterSmall {

    public void execute() {
        int[] input = {8, 4, 9, 8, 7, 3, 7, 1, 2, 6};
        
        System.out.println(arrange(input));
        
        System.out.println(arrange2(input));
    }
    
    private int[] arrange(int[] input) {
        
        Arrays.sort(input);
        int[] output = new int[input.length];
        
        for (int i = 0; i < output.length/2; i++) {
            output[2*i] = input[i];
            if(2*i + 1 < input.length) {
                output[2*i + 1] = input[output.length - 1 - i];
            }
        }
        return output;
    }
    
    private int[] arrange2(int[] input) {
        
        for(int i = 0; i < input.length - 2; i++) {
            
            if(i%2 == 0) { //even index
                if(input[i] > input[i + 1]) {
                    swap(input, i, i+1);
                }
            } else {  // odd index
                if (input[i] < input[i+1]) {
                    swap(input, i, i+1);
                }
            }
        }
        return input;
    }
    
    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    
    

}
