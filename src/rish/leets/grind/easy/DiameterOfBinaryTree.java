package rish.leets.grind.easy;

import rish.leets.grind.common.utils.TreeNode;

/**
 * Grind 75 : Week 2
 * 
 * Problem #: LC543
 * 
 * Problem link : https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * Date Attempted: 13/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class DiameterOfBinaryTree {

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
