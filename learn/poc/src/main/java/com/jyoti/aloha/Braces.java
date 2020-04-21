package com.jyoti.aloha;

public class Braces {

	public static void main(String[] args) {
//		doit("}{");
//		doit("{{{");
//		doit("{{{{");
		doit("}}{{");
		//
//		doit("{{{{}}");
//		doit("}{{}}{{{");
	}

	public static void doit(String expression) {

		if (expression == null || expression.length() == 0 || expression.length() % 2 == 1) {
			System.out.println("Can't be made balancedusing reversals");
			return;
		}

		int openBracesCount = 0;
		int result = 0;
		for (char letter : expression.toCharArray()) {

			if (letter == '{') {
				openBracesCount++;

			} else if (letter == '}') {

				if (openBracesCount > 0) {
					openBracesCount--;
				} else {
					result++;
					openBracesCount++;
				}
			}
		}

		result += openBracesCount / 2;
		System.out.println(result);
	}

}
