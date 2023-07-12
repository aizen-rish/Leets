package rish.leets.grind.easy;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 543
 * Problem link : https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * @author Rishabh Soni
 *
 */
public class DiameterOfBinaryTree {

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

    public int diameterOfBinaryTree(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftDiam = diameterOfBinaryTree(node.left);
        int rightDiam = diameterOfBinaryTree(node.right);
        int childHeight = heightOfBT(node.left) + heightOfBT(node.right);

        return Math.max(childHeight, Math.max(leftDiam, rightDiam));
    }

    private int heightOfBT(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftH = heightOfBT(node.left);
        int rightH = heightOfBT(node.right);

        return Math.max(leftH, rightH) + 1;
    }

}
