package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Grind 75 : Week 5
 * 
 * Problem #: 199
 * Problem link : https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Date Attempted: 04/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class RightViewOfTree {

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

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        int[] ans = new int[100];
        Arrays.fill(ans, -101);
        rightSideViewInternal(root, ans, 0);

        return Arrays.stream(ans).boxed().filter(i -> i != 101).toList();
    }

    private void rightSideViewInternal(TreeNode root, int[] ans, int level) {

        if (root == null) {
            return;
        }

        if (ans[level] == -101) {
            ans[level] = root.val;
        }

        rightSideViewInternal(root.right, ans, level + 1);
        rightSideViewInternal(root.left, ans, level + 1);
    }

}
