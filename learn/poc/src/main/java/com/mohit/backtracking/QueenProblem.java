package com.mohit.backtracking;

public class QueenProblem {

    int validCombinations = 0;
    
    public void execute() {
        validCombinations = 0;
        printAllCombinations(new int[8][8], 0);
        
        System.out.println("Total combinations = " + validCombinations);
    }

    private void printAllCombinations(int[][] array, int rIndex) {

        if (array.length == rIndex) {
            validCombinations++;
            printMatrix(array);
            return;
        }

        for (int c = 0; c < array[0].length; c++) {
            array[rIndex][c] = 1;

            boolean isValid = isValidMatrix(array, rIndex, c);
            if (isValid) {
                printAllCombinations(array, rIndex + 1);
            }
            array[rIndex][c] = 0;
        }

    }

    private void printMatrix(int[][] array) {
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println("");
    }
    
    private boolean isValidMatrix(int[][] array, int row, int col) {
        return isHorizontallyValid(array, row, col) && isVerticallyValid(array, row, col) && isTopLeftValid(array, row, col) && isTopRightValid(array, row, col);
    }

    private boolean isTopRightValid(int[][] array, int row, int col) {
        int r = row - 1;
        int c = col + 1;
        while(inbounds(array, r ,c)) {
            if(array[r][c] == 1) {
                return false;
            }
            r -= 1;
            c += 1;
        }
        return true;
    }

    private boolean isTopLeftValid(int[][] array, int row, int col) {
        int r = row - 1;
        int c = col - 1;
        while(inbounds(array, r ,c)) {
            if(array[r][c] == 1) {
                return false;
            }
            r -= 1;
            c -= 1;
        }
        return true;
    }

    private boolean inbounds(int[][] array, int r, int c) {
        if(r >= 0 && c >=0 && r < array.length && c < array[0].length) {
            return true;
        }
        return false;
    }

    private boolean isVerticallyValid(int[][] array, int row, int col) {
        int r = 0;
        while(r < row) {
            if(array[r][col] == 1) {
                return false;
            }
            r++;
        }
        return true;
    }

    private boolean isHorizontallyValid(int[][] array, int row, int col) {
        int c = 0;
        while(c < col) {
            if(array[row][c] == 1) {
                return false;
            }
            c++;
        }
        return true;
    }



}
