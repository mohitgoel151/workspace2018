package com.jyoti.aloha;

import java.util.List;

public class Rect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static int rectangularSum(List<List<Integer>> matrix, String coord1, String coord2) {
		
		String[] topLeft = coord1.split(",");
		String[] bottomRight = coord2.split(",");
		
		int startRow = Integer.parseInt(topLeft[0]);
		int startColumn = Integer.parseInt(topLeft[0]);
		
		int endRow = Integer.parseInt(bottomRight[0]);
		int endColumn = Integer.parseInt(bottomRight[0]);
		
		int result = 0;
		
		for(int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
			if(rowIndex >=  matrix.size()) {
				break;
			}
			
			List<Integer> row = matrix.get(rowIndex);
			
			for(int columnIndex = startColumn; columnIndex <= endColumn; columnIndex++) {
				if(columnIndex >=  row.size()) {
					break;
				}
				result += row.get(columnIndex);
			}
		}
		return result;
	}
}
