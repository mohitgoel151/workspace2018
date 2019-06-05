package com.mohit.poc.fb;

public class FbMain {
	
	public static void main(String[] args) {
		
		FbStringSum stringSum = new FbStringSum();
		stringSum.execute();
		
		FbSubMatrixSum matrix = new FbSubMatrixSum();
//		matrix.execute();
		
		FbSlidingWindow window = new FbSlidingWindow();
//		window.execute();
		
		FbMinWeightPath path = new FbMinWeightPath();
//		path.execute();
		
	}

}
