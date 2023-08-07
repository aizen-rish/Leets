package rish.leets.grind.medium;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 236
 * Problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Date Attempted: 25/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LowestCommonAncestorOfBST {

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
        return lca(root, p.val, q.val);
    }

    public TreeNode lca(TreeNode root, int p, int q) {

        if (root == null) {
            return null;
        }

        if (root.val == p || root.val == q) {
            return root;
        }

        TreeNode searchLeft = lca(root.left, p, q);
        TreeNode searchRight = lca(root.right, p, q);

        if (searchLeft == null && searchRight != null) {
            return searchRight;
        }

        if (searchLeft != null && searchRight == null) {
            return searchLeft;
        }

        if (searchLeft != null && searchRight != null) {
            return root;
        }

        return null;
    }

}
