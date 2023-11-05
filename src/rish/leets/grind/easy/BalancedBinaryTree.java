package rish.leets.grind.easy;

import rish.leets.grind.common.utils.TreeNode;

/**
 * Grind 75 : Week 2
 * 
 * Problem #: LC110
 * 
 * Problem link : https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Date Attempted: 04/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = root.left != null ? getDepth(root.left) : 0;
        int right = root.right != null ? getDepth(root.right) : 0;

        if (Math.abs(right - left) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = root.left != null ? getDepth(root.left) : 0;
        int right = root.right != null ? getDepth(root.right) : 0;

        return Math.max(left, right) + 1;
    }

}
