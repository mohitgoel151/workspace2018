package com.mohit.poc.fb;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;

public class FbStringSum {

	public void execute() {
//		assertEquals("0.0", calculateSum(".", "."));

		assertEquals("2.7", calculateSum("2.3", "0.4"));
		assertEquals("2.776", calculateSum("2.3", "0.476"));
		
		assertEquals("3.466", calculateSum("2.99", "0.476"));

		assertEquals("2.0", calculateSum("2.0", "0.0"));

		assertEquals("224.0", calculateSum("2.0", "222.0"));

	}

	private String calculateSum(String num1, String num2) {

		String[] parts1 = StringUtils.split(num1, ".");
		String[] parts2 = StringUtils.split(num2, ".");

		parts1 = beautifyParts(parts1);
		parts2 = beautifyParts(parts2);

		String fractional = addFractionalParts(parts1[1], parts2[1]);

		String[] fractionalSum = beautifyParts(StringUtils.split(fractional, "."));

		String tempInt = addIntegralPart(parts1[0], parts2[0]);
		String integralSum = addIntegralPart(tempInt, fractionalSum[0]);

		return integralSum + "." + fractionalSum[1];
	}
	
	private String addFractionalParts(String str1, String str2) {
		
		StringBuilder builder = new StringBuilder();
		
		String larger = str1.length() > str2.length() ? str1 : str2;
		String smaller = str1.length() > str2.length() ? str2 : str1;
		
		smaller = smaller + getZeroOfLength(larger.length() - smaller.length());
		
		int sum = 0;
		int carry = 0;
		
		for(int index = larger.length() - 1; index >= 0; index--) {
			sum = Integer.parseInt(String.valueOf(larger.charAt(index))) + Integer.parseInt(String.valueOf(smaller.charAt(index))) + carry;
			
			carry = sum/10;
			sum = sum % 10;
			builder.append(sum);
		}
		
		builder.append(".").append(carry);
		
		return builder.reverse().toString();
	}
	
	private String getZeroOfLength(int count) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < count; i++) {
			builder.append("0");
		}
		
		return builder.toString();
	}

	private String addIntegralPart(String str1, String str2) {
		
		StringBuilder builder = new StringBuilder();
		
		String larger = str1.length() > str2.length() ? str1 : str2;
		String smaller = str1.length() > str2.length() ? str2 : str1;
		
		smaller = getZeroOfLength(larger.length() - smaller.length()) + smaller;
		
		int sum = 0;
		int carry = 0;
		
		for(int index = larger.length() - 1; index >= 0; index--) {
			sum = Integer.parseInt(String.valueOf(larger.charAt(index))) + Integer.parseInt(String.valueOf(smaller.charAt(index))) + carry;
			
			carry = sum/10;
			sum = sum % 10;
			builder.append(sum);
		}
		
		if(carry > 0) {
			builder.append(carry);
		}
		
		return builder.reverse().toString();
	}



	private String[] beautifyParts(String[] input) {
		String[] parts = new String[2];

		if (StringUtils.isBlank(input[0])) {
			parts[0] = "0";
		} else {
			parts[0] = input[0];
		}

		if (StringUtils.isBlank(input[1])) {
			parts[1] = "0";
		} else {
			parts[1] = input[1];
		}

		return parts;
	}

}
