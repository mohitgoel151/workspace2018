package com.mohit.zzzzz;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.mohit.poc.fb.FbPoint;
import com.mohit.poc.graph.GraphQueueNode;
import com.mohit.poc.graph.GraphQueueNodeIntComparator;

public class ShortestPaths1Revise {
    
    public void execute() {

        char[][] input1 = new char[][] { 
            { 'O', 'O', 'O', 'O', 'G' }, 
            { 'O', 'W', 'W', 'O', 'O' },
            { 'O', 'O', 'O', 'W', 'O' }, 
            { 'G', 'W', 'W', 'W', 'O' }, 
            { 'O', 'O', 'O', 'O', 'G' } 
        };

        Integer[][] expOut1 = new Integer[][] { 
            { 3, 3, 2, 1, 0 }, 
            { 2, -1, -1, 2, 1 }, 
            { 1, 2, 3, -1, 2 },
            { 0, -1, -1, -1, 1 }, 
            { 1, 2, 2, 1, 0 }
        };
        
        ArrayList<String> a = new ArrayList<>();
        a.equals(null);

        Comparator<GraphQueueNode<Integer>> comparator = new GraphQueueNodeIntComparator();

        Integer[][] actOut1 = getResult(input1, comparator);

        assertEquals(true, isSame(actOut1, expOut1));

        System.out.println("All test cases Passed : " + this.getClass().getSimpleName());
    }


    private Integer[][] getResult(char[][] input, Comparator<GraphQueueNode<Integer>> comparator) {
        
        if(input == null || input.length == 0 || input[0].length == 0) {
            throw new IllegalArgumentException("");
        }

        Queue<GraphQueueNode<Integer>> queue = new PriorityQueue<>(comparator);
        
        List<FbPoint> movements = Arrays.asList(new FbPoint(0, 1), new FbPoint(1, 0), new FbPoint(0, -1), new FbPoint(-1, 0));
        
        Integer[][] result = new Integer[input.length][input[0].length];
        
        for(int row = 0; row < input.length; row++) {
            for(int column = 0; column < input[0].length; column++) {
                if(input[row][column] == 'G') {
                    queue.add(new GraphQueueNode<Integer>(row, column, 0));
                }
            }
        }
        
        while(!queue.isEmpty()) {
            GraphQueueNode<Integer> node = queue.poll();
            
            if(result[node.getX()][node.getY()] == null || result[node.getX()][node.getY()] > node.getValue()) {
                result[node.getX()][node.getY()] = node.getValue();
            }
            
            for(FbPoint move : movements) {
                
                int newRow = node.getX() + move.getRow();
                int newColumn = node.getY() + move.getColumn();
                
                if(isInBounds(input, newRow, newColumn)) {
                    
                    if(input[newRow][newColumn] == 'W') {
                        result[newRow][newColumn] = -1;
                    } else if (result[newRow][newColumn] == null) { // untraversed
                        queue.add(new GraphQueueNode<Integer>(newRow, newColumn, node.getValue() + 1));
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isInBounds(char[][] input, int row, int column) {
        if(row >= 0 && column >= 0 && row < input.length && column < input[0].length) {
            return true;
        }
        return false;
    }
    
    
    private boolean isSame(Integer[][] actOut1, Integer[][] expOut1) {
        
        if((actOut1 != null && expOut1 == null) || (actOut1 == null && expOut1 != null)) {
            return false;
        } else if (actOut1.length != expOut1.length || actOut1[0].length != expOut1[0].length) {
            return false;
        }
        
        for(int row = 0; row < actOut1.length; row++) {
            for(int column = 0; column < actOut1[0].length; column++) {
                if(actOut1[row][column] != expOut1[row][column]) {
                    return false;
                }
            }
        }
        
        return true;
    }

}
