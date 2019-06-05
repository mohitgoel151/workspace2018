package com.mohit.poc.fb;

import static org.junit.Assert.assertEquals;

/**
 * Given a matrix, transform in such a way that sum of all elements of an sub matrix is O(1)
 * @author mohgoel
 *
 */
public class FbSubMatrixSum {

	public void execute() {

		int[][] input = new int[][] 
			{ 
				{ 1, 2, 3, 4, 6 }, 
				{ 5, 3, 8, 1, 2 }, 
				{ 4, 6, 7, 5, 5 }, 
				{ 2, 4, 8, 9, 4 } 
			};
	
		int[][] auxMatrix = createAuxMatrix(input);

		assertEquals(11, getSum(auxMatrix, new FbPoint(0, 0), new FbPoint(1, 1)));
		assertEquals(38, getSum(auxMatrix, new FbPoint(2, 2), new FbPoint(3, 4)));
		assertEquals(38, getSum(auxMatrix, new FbPoint(1, 2), new FbPoint(3, 3)));
		assertEquals(51, getSum(auxMatrix, new FbPoint(1, 1), new FbPoint(3, 3)));

	}

	/**
	 * aux[i][j] - aux[i-1][j] - aux[i][j-i] + aux[i-1][j-1]
	 * 
	 * @param auxMatrix
	 * @param leftTop
	 * @param rBottom
	 * @return
	 */
    private int getSum(int[][] auxMatrix, FbPoint leftTop, FbPoint rBottom) {

        validate(auxMatrix, leftTop);
        validate(auxMatrix, rBottom);

        int leftPortion = getCellValue(auxMatrix, new FbPoint(rBottom.getRow(), leftTop.getColumn() - 1));
        int rightPortion = getCellValue(auxMatrix, new FbPoint(leftTop.getRow() - 1, rBottom.getColumn()));
        int leftTopCorner = getCellValue(auxMatrix, new FbPoint(leftTop.getRow() - 1, leftTop.getColumn() - 1));

        return auxMatrix[rBottom.getRow()][rBottom.getColumn()] - leftPortion - rightPortion + leftTopCorner;
    }

    /**
     * Create aux matrix with condition (running sum tech)
     * 1st row for all columns =>  aux[i] = aux[i-1] + input[i]
     * 1st column in all rows  =>  aux[i] = aux[i-1] + input[i]
     * 
     * remaining as
     * aux[i][j] = input[i][j] + aux[i-1][j] + aux[i][j-i] - aux[i-1][j-1]
     * 
     * @param input
     * @return
     */
    private int[][] createAuxMatrix(int[][] input) {
        int[][] auxMatrix = new int[input.length][input[0].length];

        auxMatrix[0][0] = input[0][0];
        for (int i = 1; i < input.length; i++) {
            auxMatrix[i][0] = input[i][0] + auxMatrix[i - 1][0];
        }

        for (int i = 1; i < input[0].length; i++) {
            auxMatrix[0][i] = input[0][i] + auxMatrix[0][i - 1];
        }

        for (int row = 1; row < input.length; row++) {
            for (int column = 1; column < input[0].length; column++) {
                auxMatrix[row][column] = input[row][column] + auxMatrix[row - 1][column] + auxMatrix[row][column - 1] - auxMatrix[row - 1][column - 1];
            }
        }

        return auxMatrix;

    }

    private int getCellValue(int[][] auxMatrix, FbPoint point) {

        try {
            validate(auxMatrix, point);
        } catch (IllegalArgumentException e) {
            return 0;
        }

        return auxMatrix[point.getRow()][point.getColumn()];
    }

    private void validate(final int[][] input, final FbPoint pt) {
        if (pt.getRow() < 0 || pt.getColumn() < 0 || pt.getRow() >= input.length || pt.getColumn() >= input[0].length) {
            throw new IllegalArgumentException("Invalid point");
        }
    }

}
