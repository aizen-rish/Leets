package rish.leets.grind.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1584
 * Problem link: https://leetcode.com/problems/min-cost-to-connect-all-points/
 * 
 * Date Attempted: 15/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ConnectPoints {

    public int minCostConnectPoints(int[][] points) {

        int size = points.length;

        boolean[] visited = new boolean[size];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[] { 0, 0 });

        int edgeCount = 0;
        int minCost = 0;

        Map<Integer, Integer> cache = new HashMap<>();

        while (edgeCount < size && !pq.isEmpty()) {

            int[] edge = pq.poll();
            int cost = edge[0];
            int src = edge[1];

            if (visited[src]) {
                continue;
            }

            for (int dest = 0; dest < size; dest++) {

                if (visited[dest]) {
                    continue;
                }

                int distance = manhattanDistance(points[src], points[dest]);
                int minDist = cache.getOrDefault(dest, Integer.MAX_VALUE);
                if (minDist > distance) {
                    cache.put(dest, distance);
                    pq.add(new int[] { distance, dest });
                }
            }

            edgeCount++;
            visited[src] = true;
            minCost += cost;
        }

        return minCost;
    }

    private int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {

    }

}
