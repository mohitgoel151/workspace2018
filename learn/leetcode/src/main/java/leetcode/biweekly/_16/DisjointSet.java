package leetcode.biweekly._16;

import java.util.HashSet;
import java.util.Set;

public class DisjointSet {

    public static void main(String[] args) {
        
        int number = 5;
        int[][] input = new int[][] {
            {0,1},{0,2},{3,4},{2,3}
        };
        
        
        System.out.println(makeConnected(number, input));
        
//        int a = Integer.max(2,3);
//        
//        int n = 12;
//        StringBuilder builder= new StringBuilder();
//        while(n > 0) {
//            int digit = n % 2;
//            builder.append(String.valueOf(digit));
//            n = n >> 1;
//        }
//        builder.reverse().toString();
//        System.out.println(builder);

    }
    
    public static int makeConnected(int n, int[][] connections) {
        if(n < 2) {
            return 0;
        }
        
        if(connections.length == 0) {
            return n-1;
        }
        
        if(connections.length < n-1) {
            return -1;
        }
        
        int[] parent = new int[n];
        
        for(int i = 0; i < n ; i++) {
            parent[i] = i;
        }
        
        for(int[] connection : connections) {
            int p0 = findParent(parent, connection[0]);
            int p1 = findParent(parent, connection[1]);
            
            if(p0 == p1) {
                continue;
            } else {
                parent[p0] = p1;
            }
        }
        int parents = 0;
        for(int i = 0; i < n ; i++) {
            if( parent[i] == i) {
                parents++;
            }
        }
        return parents-1;
    }
    
    public static int findParent(int[] arr, int number) {
        while(arr[number] != number) {
            number = arr[number];
        }
        return number;
    }

}
