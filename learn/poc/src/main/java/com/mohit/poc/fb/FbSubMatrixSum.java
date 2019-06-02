package com.mohit.poc.fb;

import static org.junit.Assert.assertEquals;

public class FbSubMatrixSum {

	public void execute() {

		int[][] input = new int[][] { { 1, 2, 3, 4, 6 }, { 5, 3, 8, 1, 2 }, { 4, 6, 7, 5, 5 }, { 2, 4, 8, 9, 4 } };

		int[][] auxMatrix = createAuxMatrix(input);

		assertEquals(11, getSum(auxMatrix, new Point(0, 0), new Point(1, 1)));
		assertEquals(38, getSum(auxMatrix, new Point(2, 2), new Point(3, 4)));
		assertEquals(38, getSum(auxMatrix, new Point(1, 2), new Point(3, 3)));
		assertEquals(51, getSum(auxMatrix, new Point(1, 1), new Point(3, 3)));

	}

	private int getSum(int[][] auxMatrix, Point leftTop, Point rBottom) {

		validate(auxMatrix, leftTop);
		validate(auxMatrix, rBottom);

		int leftPortion = getCellValue(auxMatrix, new Point(rBottom.getRow(), leftTop.getColumn() - 1));
		int rightPortion = getCellValue(auxMatrix, new Point(leftTop.getRow() - 1, rBottom.getColumn()));
		int leftTopCorner = getCellValue(auxMatrix, new Point(leftTop.getRow() - 1, leftTop.getColumn() - 1));

		return auxMatrix[rBottom.getRow()][rBottom.getColumn()] - leftPortion - rightPortion + leftTopCorner;
	}
	
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
				auxMatrix[row][column] = input[row][column] + auxMatrix[row - 1][column] + auxMatrix[row][column - 1]
						- auxMatrix[row - 1][column - 1];
			}
		}

		return auxMatrix;

	}

	private int getCellValue(int[][] auxMatrix, Point point) {

		try {
			validate(auxMatrix, point);
		} catch (IllegalArgumentException e) {
			return 0;
		}

		return auxMatrix[point.getRow()][point.getColumn()];
	}

	private void validate(final int[][] input, final Point pt) {
		if (pt.getRow() < 0 || pt.getColumn() < 0 || pt.getRow() >= input.length || pt.getColumn() >= input[0].length) {
			throw new IllegalArgumentException("Invalid point");
		}
	}

	private class Point {
		int row;
		int column;

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}

		public Point(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}

	}

}
