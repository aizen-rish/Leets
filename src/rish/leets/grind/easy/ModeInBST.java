package rish.leets.grind.easy;

import java.util.ArrayList;
import java.util.List;

import rish.leets.grind.common.utils.TreeNode;

/**
 * Daily Challenge!
 * 
 * Problem #: LC501
 * 
 * Problem link: https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * 
 * Date Attempted: 01/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ModeInBST {

    int curr = 0;
    int count = 0;
    int maxCount = 0;

    List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        findModeInternal(root);

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void findModeInternal(TreeNode node) {

        if (node == null) {
            return;
        }

        findModeInternal(node.left);

        int val = node.val;
        if (val == curr) {
            count++;
        } else {
            count = 1;
            curr = val;
        }

        if (count > maxCount) {
            ans.clear();
            maxCount = count;
        }

        if (count == maxCount) {
            ans.add(curr);
        }

        findModeInternal(node.right);
    }

}
