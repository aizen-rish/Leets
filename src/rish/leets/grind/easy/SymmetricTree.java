package rish.leets.grind.easy;

import rish.leets.grind.common.utils.TreeNode;

/**
 * Practice Prep - 150
 * 
 * Problem #: LC101
 * 
 * Problem link: https://leetcode.com/problems/symmetric-tree/
 * 
 * Date Attempted: 05/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

}
