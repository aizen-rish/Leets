package rish.leets.grind.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1361
 * Problem link: https://leetcode.com/problems/validate-binary-tree-nodes/
 * 
 * Date Attempted: 17/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ValidateBT {

    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {

        int[] indegree = new int[n];

        for (int i=0; i<n; i++) {
            if (left[i] != -1) {
                indegree[left[i]]++;
            }
            if (right[i] != -1) {
                indegree[right[i]]++;
            }
        }

        int root = -1;
        for (int i=0; i<n; i++) {
            if (indegree[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }

        if (root == -1) {
            return false;
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int node = queue.remove();
            if (visited[node]) {
                return false;
            }

            visited[node] = true;

            if (left[node] != -1) {
                queue.add(left[node]);
            }

            if (right[node] != -1) {
                queue.add(right[node]);
            }
        }

        for (boolean bool: visited) {
            if (!bool) {
                return false;
            }
        }

        return true;
    }

}
