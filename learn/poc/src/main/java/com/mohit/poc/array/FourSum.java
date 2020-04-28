package com.mohit.poc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/4sum/
 * 
 * For 3 Sum ... refer ThreeSum.java file
 * TODO: 
 */
public class FourSum {

	public static void main(String[] args) {
		FourSumSolution sol = new FourSumSolution();
		
		System.out.println(sol.fourSum(new int[] {-1,0,-5,-2,-2,-4,0,1,-2}, -9));

	}

}

class FourSumSolution {
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        /*
         * This derives lot of optimization decisions (ensuring next numbers will be >= current)
         */
        Arrays.sort(nums);
        
        for(int i = 0; i <= nums.length-4; i++) {
        	
        	/*
        	 * If current and previous values at ith index are same, then continue to avoid duplicate
        	 */
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            /*
             * Over flow checks
             * If 4 times value at i is greater than target .. then we can break it, in-fact we can directly return from here
             */
            if(4*nums[i] > target) {
            	return result;
            } else if (4*nums[i] == target && i+3 < nums.length && nums[i] == nums[i+3]) {
            	
            	/*
            	 * If 4*values is same then ensure i+3 is same as well and if thats so, add to result and return back.
            	 */
                result.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
                return result;
            }
            
            for(int j = i+1; j <= nums.length-3; j++) {
            	
            	/*
            	 * Same over flow checks can be added here as well 
            	 */
            	
                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                
                int low = j+1;
                int high = nums.length-1;
                
                while(low < high) {
                	
                	/*
                	 * Same over flow checks can be added here as well for low and high
                	 */
                    if(low > j+1 && nums[low] == nums[low-1]) {
                        low++;
                        continue;
                    } else if (high < nums.length-1 && nums[high] == nums[high+1]) {
                        high--;
                        continue;
                    }
                    
                    
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    
                    if(sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high])); 
                        high--;
                        low++;
                    } else if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}