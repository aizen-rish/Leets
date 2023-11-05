package rish.leets.grind.medium;

import rish.leets.grind.common.utils.TreeNode;

/**
 * Grind 75 : Week 2
 * 
 * Problem #: LC235
 * 
 * Problem link :
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * Date Attempted: 05/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LowestCommonAncestor {

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
