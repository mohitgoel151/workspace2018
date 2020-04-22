package com.mohit.poc.misc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/
 * 
 * Given the string croakOfFrogs, which represents a combination of the string "croak" from different frogs, that is, 
 * multiple frogs can croak at the same time, so multiple “croak” are mixed. 
 * Return the minimum number of different frogs to finish all the croak in the given string.

	A valid "croak" means a frog is printing 5 letters ‘c’, ’r’, ’o’, ’a’, ’k’ sequentially. 
	The frogs have to print all five letters to finish a croak. If the given string is not a combination of valid "croak" return -1.
 */
public class Croaking {

	public static void main(String[] args) {
		CroakingSolution sol = new CroakingSolution();
		sol.execute();
	}
}

/*
 * 
 */
class CroakingSolution {
	
	public void execute() {
		assertEquals(-1, minNumberOfFrogs("crccoakroarookk"));
		assertEquals(2, minNumberOfFrogs("crcoakroak"));
		assertEquals(-1, minNumberOfFrogs("rccoakroak"));
		assertEquals(1, minNumberOfFrogs("croakcroak"));
		System.out.println("All passes " + this.getClass().getSimpleName());
	}
	
	/*
	 * Manage how many chars are already consumed
	 */
	private int minNumberOfFrogs(String croakOfFrogs) {

		if (croakOfFrogs == null || croakOfFrogs.length() % 5 != 0) {
			return -1;
		}

		List<Character> chars = Arrays.asList('c', 'r', 'o', 'a', 'k');

		int[] freq = new int[26];
		int result = 0;
		int temp = 0;

		//For each char increase the frequency count
		for (char aChar : croakOfFrogs.toCharArray()) {
			freq[aChar - 'a']++;

			/*
			 * whenever we get C that means a new would is starting and add it to temp counter
			 */
			if (aChar == 'c') {
				result = Math.max(result, ++temp);
			} else if (aChar == 'k') {
				if (--temp < 0) {
					return -1;
				}
				/*
				 * At each k word gets completed. So we will be decrementing the count of self along with count of other characters
				 */
				freq[aChar - 'a']--;
			}

			/*
			 * This is the trick of the question.
			 * At each char we decrement the count of previous char count and if at any time count go below 0, we return -1.
			 * 
			 * Example "acrok". This string contains all chars but 'a' is coming before 'c' which is invalid. 
			 * Now when we try to decrease count of its previous char 'o' and  o's count become -1 which is invalid state.
			 */
			if (aChar != 'c') {
				int index = chars.indexOf(aChar);
				char preChar = chars.get(index - 1);
				freq[preChar - 'a']--;
				if (freq[preChar - 'a'] < 0) {
					return -1;
				}
			}

		}
		/*
		 * If count of all chars is 0 that means all words are complete and we can return back the max occurrence of 'c' (captured in result)
		 */
		return isEmpty(freq, chars) ? result : -1;
	}

	private boolean isEmpty(int[] freq, List<Character> chars) {
		for (Character aChar : chars) {
			if (freq[aChar - 'a'] != 0) {
				return false;
			}
		}
		return true;
	}
}