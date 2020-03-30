package com.mohit.poc.fb;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/minimum-cost-path-left-right-bottom-moves-allowed/
 * 
 * It is "not" possible to solve this problem using dynamic programming similar to previous problem because here current 
 * state depends not only on right and bottom cells but also on left and upper cells. 
 * We solve this problem using dijkstra’s algorithm
 * 
 * UnMarked Cells => Int.MAX 
 * Marked Cells => +ve value but less than Int.MAX
 * Traversed cells => -ve value
 * 
 * Initially all cells values are marked as un-traversed by setting value = INT.MAX 
 * Traversed cell values are made -ve 
 * Cell values > 0 and < Int.MAX are marked(touched) cell from whom "getShortedWeightCell" is returned
 *
 */
public class FbMinWeightPath {

    private static final FbPoint DEAD_CELL = new FbPoint(-1, -1);
    private static final List<FbPoint> fourAllowedMoves = Collections.unmodifiableList(Arrays.asList(new FbPoint(0, 1), new FbPoint(1, 0), new FbPoint(0, -1), new FbPoint(-1, 0)));
    private static final List<FbPoint> eightAllowedMoves = Collections.unmodifiableList(
            Arrays.asList(new FbPoint(0, 1), new FbPoint(1, 1), new FbPoint(1, 0), new FbPoint(1, -1), new FbPoint(0, -1), new FbPoint(-1, -1), new FbPoint(-1, 0), new FbPoint(-1, 1)));

    private List<FbPoint> allowedMoves;

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
    }

    /**
     * Return the cost and print the path from start till end
     * 
     * @param input
     * @param start
     * @param end
     * @return
     */
    private int shortestPathWeight(int[][] input, FbPoint start, FbPoint end) {

        int result = 0;
        int[][] traversalMatrix = createAndFillWith(input.length, input[0].length, Integer.MAX_VALUE);
        traversalMatrix[start.getRow()][start.getColumn()] = input[start.getRow()][start.getColumn()];

        while (true) {

            FbPoint currentPoint = getShortedWeightCell(traversalMatrix);

            if (DEAD_CELL.equals(currentPoint)) {
                throw new RuntimeException("Dead Cell encountered");
            }

            if (currentPoint.equals(end)) {
                result = traversalMatrix[end.getRow()][end.getColumn()];
                printPath(input, traversalMatrix, currentPoint);
                break;
            } else {
                List<FbPoint> adjancetCells = getAdjacentUnTraversedCells(traversalMatrix, currentPoint);
                for (FbPoint adjPoint : adjancetCells) {
                    int newWeight = traversalMatrix[currentPoint.getRow()][currentPoint.getColumn()] + input[adjPoint.getRow()][adjPoint.getColumn()];
                    if (newWeight < traversalMatrix[adjPoint.getRow()][adjPoint.getColumn()]) {
                        traversalMatrix[adjPoint.getRow()][adjPoint.getColumn()] = newWeight;
                    }
                }
            }
            traversalMatrix[currentPoint.getRow()][currentPoint.getColumn()] *= -1;
        }

        return result;
    }

    private void printPath(int[][] input, int[][] traversalMatrix, FbPoint currentPoint) {

        System.out.println();
        System.out.println("*************************************");

        List<FbPoint> path = new ArrayList<>();
        path.add(currentPoint);
        getPathPoints(input, traversalMatrix, currentPoint, path);
        for (FbPoint fbPoint : path) {
            System.out.println(fbPoint);
        }

    }

    /**
     * Traverse backwards in recursion. Jump to adjacent cell which is 
     * 1. Traversed (has -ve value) 
     * 2. Satisfy this condition (adjCellValue + inputMatCellValue == traMatCellValue) And keep adding it to list
     * 
     * @param input
     * @param traversalMatrix
     * @param currentPoint
     * @param path
     * @return
     */
    private boolean getPathPoints(int[][] input, int[][] traversalMatrix, FbPoint currentPoint, List<FbPoint> path) {

        int traMatCellValue = Math.abs(traversalMatrix[currentPoint.getRow()][currentPoint.getColumn()]);
        int inputMatCellValue = input[currentPoint.getRow()][currentPoint.getColumn()];

        if (inputMatCellValue == traMatCellValue) {
            return true;
        }

        List<FbPoint> adjancetCells = getAdjacentTraversedCells(traversalMatrix, currentPoint);

        for (FbPoint adjCell : adjancetCells) {

            int adjCellValue = Math.abs(traversalMatrix[adjCell.getRow()][adjCell.getColumn()]);

            if (adjCellValue + inputMatCellValue == traMatCellValue) {
                path.add(adjCell);
                boolean isComplete = getPathPoints(input, traversalMatrix, adjCell, path);
                if (isComplete) {
                    return true;
                }
            }
        }
        throw new RuntimeException("Couldn't find path");
    }

    /**
     * Traverse the matrix and return cell coordinate which is un-traversed and has
     * smallest value
     * 
     * TODO: this method can be optimized if we can track untraversed marked cells in min priority queue 
     * 
     * @param traversalMatrix
     * @return
     */
    private FbPoint getShortedWeightCell(int[][] traversalMatrix) {
        FbPoint point = DEAD_CELL;
        int weight = Integer.MAX_VALUE;
        for (int row = 0; row < traversalMatrix.length; row++) {
            for (int column = 0; column < traversalMatrix[0].length; column++) {
                if (isNotTraversed(row, column, traversalMatrix)) {
                    if (traversalMatrix[row][column] < weight) {
                        weight = traversalMatrix[row][column];
                        point = new FbPoint(row, column);
                    }
                }
            }
        }
        return point;
    }

    private List<FbPoint> getAdjacentUnTraversedCells(int[][] traversalMatrix, FbPoint cell) {
        List<FbPoint> cells = new ArrayList<>();
        
        List<FbPoint> adjacentCells = getAdjacentCells(traversalMatrix, cell);
        for (FbPoint fbPoint : adjacentCells) {
            if (isNotTraversed(fbPoint, traversalMatrix)) {
                cells.add(fbPoint);
            }
        }
        return cells;

    }

    private List<FbPoint> getAdjacentTraversedCells(int[][] traversalMatrix, FbPoint cell) {
        List<FbPoint> cells = new ArrayList<>();
        List<FbPoint> adjacentCells = getAdjacentCells(traversalMatrix, cell);
        for (FbPoint fbPoint : adjacentCells) {
            if (isTraversed(fbPoint, traversalMatrix)) {
                cells.add(fbPoint);
            }
        }
        return cells;
    }

    /**
     * Return list of bounded adjacent cells
     * 
     * @param traversalMatrix
     * @param cell
     * @return
     */
    private List<FbPoint> getAdjacentCells(int[][] traversalMatrix, FbPoint cell) {
        List<FbPoint> cells = new ArrayList<>();

        for (FbPoint fbPoint : allowedMoves) {
            FbPoint temp = new FbPoint(cell.getRow() + fbPoint.getRow(), cell.getColumn() + fbPoint.getColumn());
            if (isInBounds(temp, traversalMatrix)) {
                cells.add(temp);
            }

        }
        return cells;
    }

    private boolean isNotTraversed(int row, int column, int[][] traversalMatrix) {
        return !isTraversed(new FbPoint(row, column), traversalMatrix);
    }

    private boolean isNotTraversed(FbPoint temp, int[][] traversalMatrix) {
        return !isTraversed(temp, traversalMatrix);
    }

    private boolean isTraversed(FbPoint temp, int[][] traversalMatrix) {
        if (traversalMatrix[temp.getRow()][temp.getColumn()] < 0) {
            return true;
        }
        return false;
    }

    private boolean isInBounds(FbPoint temp, int[][] traversalMatrix) {
        if (temp.getRow() < 0 || temp.getColumn() < 0 || temp.getRow() >= traversalMatrix.length || temp.getColumn() >= traversalMatrix[0].length) {
            return false;
        }
        return true;
    }

    private int[][] createAndFillWith(int rows, int columns, int value) {
        int[][] output = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                output[row][column] = value;
            }
        }

        return output;
    }

}
