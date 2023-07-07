package rish.leets.grind.medium;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 235
 * Problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * @author Rishabh Soni
 *
 */
public class LowestCommonAncestor {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

}
