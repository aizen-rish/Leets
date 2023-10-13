package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Daily Challenge!
 * 
 * Problem #: 1615
 * Problem link: https://leetcode.com/problems/maximal-network-rank/
 * 
 * Date Attempted: 18/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {

        if (roads.length == 0) {
            return 0;
        }

        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] road : roads) {
            int i = road[0];
            int j = road[1];
            indegree[i]++;
            indegree[j]++;
            adj.get(i).add(j);
            adj.get(j).add(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int rank = indegree[i] + indegree[j];
                    if (adj.get(i).contains(j)) {
                        rank--;
                    }
                    max = Math.max(max, rank);
                }
            }
        }

        return max;
    }

}
