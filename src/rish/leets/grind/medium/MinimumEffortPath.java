package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Daily Challenge!
 * 
 * Problem #: 1631
 * Problem link: https://leetcode.com/problems/path-with-minimum-effort/
 * 
 * Date Attempted: 16/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MinimumEffortPath {

    record Pair(int key, int value) {
    }

    private static final int[][] MOVES = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] graph = new int[rows][cols];

        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        graph[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {

            int[] node = pq.poll();

            int i = node[0];
            int j = node[1];
            int cost = node[2];

            if (i == rows - 1 && j == cols - 1) {
                return cost;
            }

            for (int[] move : MOVES) {
                int x = move[0] + i;
                int y = move[1] + j;
                if (!isNotValid(x, y, rows, cols)) {
                    int moveCost = Math.max(cost, Math.abs(heights[i][j] - heights[x][y]));
                    if (moveCost < graph[x][y]) {
                        graph[x][y] = moveCost;
                        pq.add(new int[] { x, y, moveCost });
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isNotValid(int x, int y, int m, int n) {
        return x < 0 || x > m - 1 || y < 0 || y > n - 1;
    }

}
