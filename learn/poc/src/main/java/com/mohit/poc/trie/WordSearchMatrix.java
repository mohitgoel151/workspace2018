package com.mohit.poc.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-search-ii/
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example:

	Input: 
	board = [
	  ['o','a','a','n'],
	  ['e','t','a','e'],
	  ['i','h','k','r'],
	  ['i','f','l','v']
	]
	words = ["oath","pea","eat","rain"]

	Output: ["eat","oath"]
 */
public class WordSearchMatrix {

	public static void main(String[] args) {
		WordSearchMatrixSolution sol = new WordSearchMatrixSolution();

		char[][] board = new char[][] { 
			{ 'o', 'a', 'a', 'n' }, 
			{ 'e', 't', 'a', 'e' }, 
			{ 'i', 'h', 'k', 'r' },
			{ 'i', 'f', 'l', 'v' } 
		};

		String[] words = new String[] { "oath", "pea", "eat", "rain", "aan", "flv", "athf" ,"oeiiflvrkhtaenaa"};

		System.out.println(sol.findWords(board, words));

	}

}

class WordSearchMatrixSolution {

	int[][] moves = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public List<String> findWords(char[][] board, String[] words) {

		TrieNodee root = createTrie(words);
		Set<String> result = new HashSet<>();
		boolean[][] traversed = null;

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				char start = board[row][col];
				TrieNodee node = root.children[start - 'a'];
				if (node != null) {
					traversed = new boolean[board.length][board[0].length];
					StringBuilder builder = new StringBuilder();
					builder.append(String.valueOf(start));
					traversed[row][col] = true;
					checkAndAddWord(board, traversed, row, col, node, result, builder);
				}
			}
		}
		return new ArrayList<>(result);
	}

	private void checkAndAddWord(char[][] board, boolean[][] traversed, int row, int col, TrieNodee node,
			Set<String> result, StringBuilder builder) {

		if (node != null && node.complete) {
			result.add(builder.toString());
		}

		for (int[] move : moves) {
			int newRow = row + move[0];
			int newCol = col + move[1];

			if (isMovable(traversed, newRow, newCol)) {
				char charValue = board[newRow][newCol];

				TrieNodee charValueNode = node.children[charValue - 'a'];
				if (charValueNode != null) {
					traversed[newRow][newCol] = true;
					builder.append(String.valueOf(charValue));
					checkAndAddWord(board, traversed, newRow, newCol, charValueNode, result, builder);
					traversed[newRow][newCol] = false;
					builder.deleteCharAt(builder.length() - 1);
				}
			}
		}

	}

	private boolean isMovable(boolean[][] traversed, int row, int col) {
		if (row < 0 || row >= traversed.length || col < 0 || col >= traversed[0].length || traversed[row][col]) {
			return false;
		}
		return true;
	}

	private TrieNodee createTrie(String[] words) {
		TrieNodee root = new TrieNodee('\0');

		for (String word : words) {
			if (word != null && word.length() > 0) {
				addWord(root, word.toLowerCase(), 0);
			}
		}
		return root;
	}

	private void addWord(TrieNodee node, String word, int index) {
		if (index == word.length()) {
			return;
		}

		char fChar = word.charAt(index);
		TrieNodee childNode = node.children[fChar - 'a'];
				
		if (childNode == null) {
			childNode = new TrieNodee(fChar);
			node.children[fChar - 'a'] = childNode;
		}

		addWord(childNode, word, index + 1);
		
		if (index == word.length() - 1) {
			node.children[fChar - 'a'].complete = true;
		}
	}
}

class TrieNodee {
	char value;
	TrieNodee[] children = new TrieNodee[26];
	boolean complete = false;

	public TrieNodee(char nValue) {
		value = nValue;
	}
}