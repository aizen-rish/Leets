package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1743
 * 
 * Problem link:
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 * 
 * Date Attempted: 10/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class RestoreArray {

    public static int[] restoreArray(int[][] adjacentPairs) {

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] pair : adjacentPairs) {

            int x = pair[0];
            int y = pair[1];

            adj.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        int start = -1;
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        return dfs(adj, start);
    }

    private static int[] dfs(Map<Integer, List<Integer>> adj, int start) {

        List<Integer> ans = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            int node = q.poll();
            visited.add(node);
            ans.add(node);

            for (Integer neighbour : adj.get(node)) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                }
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private static int[] iterativeDfs(Map<Integer, List<Integer>> adj, int start) {

        int[] ans = new int[adj.size()];

        int curr = start;
        int prev = Integer.MIN_VALUE;

        int i = 0;
        ans[i++] = curr;

        while (i < adj.size()) {
            for (int neighbour : adj.get(curr)) {
                if (neighbour != prev) {
                    ans[i++] = neighbour;
                    prev = curr;
                    curr = neighbour;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] pairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };

        int[] ans = restoreArray(pairs);
        System.out.println(Arrays.toString(ans));
    }

}
