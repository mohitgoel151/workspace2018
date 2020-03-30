package com.mohit.poc.fb;

public class StringOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class StringOperationsSol {

//	"1234", +/-, 2
//	"1+2+3-4" = 2
//	"-1+2-3+4" = 2
//	  
//	"1121122", 2
//	"112-112 + 2" = 2
//	"-112+112+2" = 2
//	"11 + 2 - 11 + 2 - 2" = 2
//	  
//	"77", 9 - no solution
//
//	+1+2+3-4 - > 1+2+3-4
//	  
//	"1...1" - 1 mil +1 1 -> 1-1+1-1 + ...1
//	  
//	"1" 1
//	  
//	"1234"
//	"1"
//	"12"
//	"123"
//	"1234"

	public void printCombinations(String input, int target) {

		// validation

		printCombinations(input, target, 0, new StringBuilder());

	}

	private void printCombinations(String input, int target, int total, StringBuilder builder) {

		if (input.length() == 0) {
			if (total == target) {
				System.out.println(builder.toString());
			}
		}

		int no = 0;
		
		for (int index = 0; index < input.length(); index++) { // TODO over length

			no = no * 10 + input.charAt(index) - '0';

			int builderLength = builder.length();
			String suffixString = input.substring(index + 1);
			String strNumber = String.valueOf(no);

			if (builderLength > 0) {
				builder.append("+");
			}
			builder.append(strNumber);
			printCombinations(suffixString, target + no, total, builder);
			builder.substring(0, builderLength); // keep string only with this length

			// For -ve operation
			builder.append("-");
			builder.append(strNumber);
			printCombinations(suffixString, target - no, total, builder);
			builder.substring(0, builderLength); // keep string only with this length

		}

	}

}