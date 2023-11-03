package rish.leets.grind.easy;

import rish.leets.grind.common.utils.TreeNode;

/**
 * Grind 75 : Week 2
 * 
 * Problem #: LC226
 * 
 * Problem link : https://leetcode.com/problems/invert-binary-tree/
 * 
 * Date Attempted: 04/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class InvertBinaryTree {

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
