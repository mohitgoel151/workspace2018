package com.mohit.zzzzz;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mohit.poc.fb.FbPoint;

public class FbMinPathRevise {
    
    private List<FbPoint> allowedMoves;
    private List<FbPoint> fourAllowedMoves;
    private List<FbPoint> eightAllowedMoves;
    
    
    public FbMinPathRevise() {
        fourAllowedMoves = Collections.unmodifiableList(Arrays.asList(new FbPoint(0, 1), new FbPoint(1, 0), new FbPoint(0, -1), new FbPoint(-1, 0)));
        eightAllowedMoves = Collections.unmodifiableList(Arrays.asList(new FbPoint(0, 1), new FbPoint(1, 1),new FbPoint(1, 0), new FbPoint(1, -1),new FbPoint(0, -1), new FbPoint(-1,  -1), new FbPoint(-1, 0), new FbPoint(-1, 1)));
    }
    
    public void execute() {

        int[][] input = new int[][] 
            { 
                { 31, 100, 65, 12, 18 }, 
                { 10, 13, 47, 157, 6 }, 
                { 100, 113, 174, 11, 33 }, 
                { 88, 124, 41, 20, 140 }, 
                { 99, 32, 111, 41, 20 } 
            };

        allowedMoves = fourAllowedMoves;
        assertEquals(327, shortestPathWeight(input, new FbPoint(0, 0), new FbPoint(input.length - 1, input[0].length - 1)));
        assertEquals(149, shortestPathWeight(input, new FbPoint(0, input[0].length - 1), new FbPoint(input.length - 1, input[0].length - 1)));

        System.out.println("");
        System.out.println("8 Cell movement");
        allowedMoves = eightAllowedMoves;
        assertEquals(142, shortestPathWeight(input, new FbPoint(0, 0), new FbPoint(input.length - 1, input[0].length - 1)));
        assertEquals(75, shortestPathWeight(input, new FbPoint(0, input[0].length - 1), new FbPoint(input.length - 1, input[0].length - 1)));
        
        System.out.println("All test cases passed " + this.getClass().getSimpleName());
    }

    private int shortestPathWeight(int[][] input, FbPoint start, FbPoint end) {
        
        int[][] traversalMatrix = fetchTraversalMatrix(input.length, input[0].length, Integer.MAX_VALUE);
        
        FbPoint current = start;
        
        traversalMatrix[start.getRow()][start.getColumn()] = input[start.getRow()][start.getColumn()];
        
        Set<FbPoint> markedCells = new HashSet<>();
        markedCells.add(current);
        
        while(!markedCells.isEmpty()) {
            
            List<FbPoint> cells = getAllUntraversedCells(traversalMatrix, current);
            
            for(FbPoint cell : cells) {
                traversalMatrix[cell.getRow()][cell.getColumn()] = traversalMatrix[current.getRow()][current.getColumn()] + input[cell.getRow()][cell.getColumn()];
                if(cell.getRow() == end.getRow() && cell.getColumn() == end.getColumn()) {
                    return traversalMatrix[end.getRow()][end.getColumn()];
                }
            }
            
            markedCells.addAll(cells);
            markedCells.remove(current);
            traversalMatrix[current.getRow()][current.getColumn()] = (-1) * Math.abs(traversalMatrix[current.getRow()][current.getColumn()]);
            
            current = getMinimumWeightCell(traversalMatrix, markedCells);
        }
        
        return Integer.MAX_VALUE;
    }
    
    private FbPoint getMinimumWeightCell(int[][] traversalMatrix, Set<FbPoint> markedCells) {
        int minValue = Integer.MAX_VALUE;
        FbPoint nextCell = null;
        
        for(FbPoint cell : markedCells) {
            if(traversalMatrix[cell.getRow()][cell.getColumn()] > 0 && traversalMatrix[cell.getRow()][cell.getColumn()] < minValue) {
                minValue = traversalMatrix[cell.getRow()][cell.getColumn()];
                nextCell = cell;
            }
        }
        
        return nextCell;
    }

    private List<FbPoint> getAllUntraversedCells(int[][] traversal, FbPoint cell) {
        
        List<FbPoint> cells = new ArrayList<>();
        
        for (FbPoint move : allowedMoves) {
            FbPoint jumpedCell = cellWithMove(cell, move);
            if(isInBounds(traversal, jumpedCell) && isUntraversed(traversal, jumpedCell)) {
                cells.add(jumpedCell);
            }
        }
        return cells;
    }
    
    private boolean isUntraversed(int[][] matrix, FbPoint cell) {
        if(matrix[cell.getRow()][cell.getColumn()] == Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }
    
    
    private FbPoint cellWithMove(FbPoint current, FbPoint move) {
        return new FbPoint(current.getRow() + move.getRow(), current.getColumn() + move.getColumn());
    }
    
    private boolean isInBounds(int[][] matrix, FbPoint cell) {
        if (cell.getRow() < 0 || cell.getColumn() < 0 || cell.getRow() >= matrix.length || cell.getColumn() >= matrix[0].length) {
            return false;
        }
        return true;
    }
    
    private int[][] fetchTraversalMatrix(int rows, int columns, int defaultValue) {
        int[][] traversalMatrix = new int[rows][columns];
        
        for(int row = 0; row < rows; row++) {
           for(int col = 0; col < columns; col++) {
               traversalMatrix[row][col] = defaultValue;
           }
        }
        return traversalMatrix;
    }

}
