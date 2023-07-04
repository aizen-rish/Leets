package rish.leets.grind.easy;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 226
 * Problem link : https://leetcode.com/problems/invert-binary-tree/
 * 
 * @author Rishabh Soni
 *
 */
public class InvertBinaryTree {

	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		if (root.left != null) {
			invertTree(root.left);
		}

		if (root.right != null) {
			invertTree(root.right);
		}

		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		return root;
	}

}
