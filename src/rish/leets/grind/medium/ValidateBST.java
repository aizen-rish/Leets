package rish.leets.grind.medium;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 98
 * Problem link : https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Date Attempted: 25/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ValidateBST {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            this.val = x;
        }

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lPivot, Integer rPivot) {

        if (root == null) {
            return true;
        }

        int val = root.val;

        if (lPivot != null && val <= lPivot) {
            return false;
        }

        if (root.left != null && root.left.val >= val) {
            return false;
        }

        if (rPivot != null && val >= rPivot) {
            return false;
        }

        if (root.right != null && root.right.val <= val) {
            return false;
        }

        return isValidBST(root.left, lPivot, val) && isValidBST(root.right, val, rPivot);
    }

}
