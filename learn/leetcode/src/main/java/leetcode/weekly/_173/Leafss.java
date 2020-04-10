package leetcode.weekly._173;

public class Leafss {

	public static void main(String[] ar) {
		
		int c = "adz".compareTo("adbbz");
		System.out.println(c);

		//[25,1,3,1,3,0,2]
		TreeNode root = new TreeNode(25);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		root.right = new TreeNode(3);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(2);
		
		System.out.println(smallestFromLeaf(root));
		System.out.println(smallestFromLeafMohit(root));

	}

	///

	public static String smallestFromLeafMohit(TreeNode root) {

		if (root == null) {
			return "";
		}
		return helper(root, new StringBuilder(), null);
	}

	private static String helper(TreeNode node, StringBuilder temp, String min) {

		if(node == null) {
			return null;
		}

		char aChar = (char) (node.val + 'a');
		temp.append(String.valueOf(aChar));
		
		if (node.left == null && node.right == null) {
			String tempReverse = new StringBuilder(temp.toString()).reverse().toString();
			temp.deleteCharAt(temp.length() - 1);
			if (min == null) {
				return tempReverse;
			}
			int compare = tempReverse.compareTo(min);
			return compare < 0 ? tempReverse : min;
		}
		
		if(node.left != null) {
			min = helper(node.left, temp, min);
		}
		
		if(node.right != null) {
			min = helper(node.right, temp, min);
		}

		temp.deleteCharAt(temp.length() - 1);

		return min;

	}

	///

	static String ans = "~";

	public static String smallestFromLeaf(TreeNode root) {
		dfs(root, new StringBuilder());
		return ans;
	}

	public static void dfs(TreeNode node, StringBuilder sb) {
		if (node == null)
			return;
		sb.append((char) ('a' + node.val));

		if (node.left == null && node.right == null) {
			sb.reverse();
			String S = sb.toString();
			sb.reverse();

			if (S.compareTo(ans) < 0)
				ans = S;
		}

		dfs(node.left, sb);
		dfs(node.right, sb);
		sb.deleteCharAt(sb.length() - 1);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}