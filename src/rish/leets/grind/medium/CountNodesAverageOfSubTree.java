package rish.leets.grind.medium;

import rish.leets.grind.common.utils.TreeNode;

/**
 * Daily Challenge!
 * 
 * Problem #: LC2265
 * 
 * Problem link:
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 * 
 * Date Attempted: 02/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CountNodesAverageOfSubTree {

    class Node {
        int sum;
        int count;

        public Node(int i, int j) {
            this.sum = i;
            this.count = j;
        }
    }

    private int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        avgInternal(root);
        return ans;
    }

    private Node avgInternal(TreeNode node) {

        if (node == null) {
            return null;
        }

        Node left = avgInternal(node.left);
        Node right = avgInternal(node.right);

        int sum = node.val;
        int count = 1;

        if (left != null) {
            sum += left.sum;
            count += left.count;
        }

        if (right != null) {
            sum += right.sum;
            count += right.count;
        }

        if (sum / count == node.val) {
            ans++;
        }

        return new Node(sum, count);
    }

}
