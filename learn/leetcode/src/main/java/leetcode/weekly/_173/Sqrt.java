package leetcode.weekly._173;

public class Sqrt {

    public static void main(String[] args) {
        
        System.out.println(mysqrt(2147483647));

    }
    
    public static int mysqrt(int x) {
        
        if(x == 0) {
            return 0;
        }
        
        if(x < 4) {
            return 1;
        }
        
        int low = 1;
        int high = x/2;
        
        return sqrt(x, low, high);
        
    }
    
    public static int sqrt(int x, int low, int high) {
        int result = low;
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(mid >= (Integer.MAX_VALUE/mid)) {
                high = mid-1;
                continue;
            }
            
            
            int power = mid*mid;
            
            if(power == x) {
                return mid;
            } else if (x > power) {
                if(result < mid) {
                    result = mid;
                }
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;
    }

}
