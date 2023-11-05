package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rish.leets.grind.common.utils.TreeNode;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: LC102
 * 
 * Problem link : https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Date Attempted: 18/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> answer = new ArrayList<>();
        levelOrderInternal(root, answer, 0);

        return answer;
    }

    private void levelOrderInternal(TreeNode node, List<List<Integer>> answer, int level) {

        if (level >= answer.size()) {
            List<Integer> currLevel = new ArrayList<>();
            currLevel.add(node.val);
            answer.add(currLevel);
        } else {
            answer.get(level).add(node.val);
        }

        if (node.left != null) {
            levelOrderInternal(node.left, answer, level + 1);
        }

        if (node.right != null) {
            levelOrderInternal(node.right, answer, level + 1);
        }
    }

}
