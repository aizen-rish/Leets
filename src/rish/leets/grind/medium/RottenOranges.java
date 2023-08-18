package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

    private static final int[][] MOVES = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    record Pair(int x, int y) {
    }

    public static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean hasFreshOranges = false;

        // Add all rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hasFreshOranges = hasFreshOranges || grid[i][j] == 1;
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        // There are no oranges to poison
        if (!hasFreshOranges) {
            return 0;
        }

        // There are no rotten oranges
        if (q.isEmpty()) {
            return -1;
        }

        while (!q.isEmpty()) {

            Pair node = q.poll();

            if (grid[node.x][node.y] == 1) {
                grid[node.x][node.y] = 3;
            }

            List<Pair> nextNodes = nextNodes(grid, node, m, n);

            for (Pair next : nextNodes) {
                grid[next.x][next.y] += grid[node.x][node.y];
                q.add(next);
            }
        }

        int minutes = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                } else if (grid[i][j] >= 2) {
                    minutes = Math.max(minutes, grid[i][j] - 2);
                }
            }
        }

        return minutes;
    }

    private static List<Pair> nextNodes(int[][] grid, Pair node, int m, int n) {

        List<Pair> ans = new ArrayList<>();

        for (int[] move : MOVES) {
            int x = move[0] + node.x;
            int y = move[1] + node.y;
            if (!isNotValid(x, y, m, n) && grid[x][y] == 1) {
                ans.add(new Pair(x, y));
            }
        }

        return ans;
    }

    private static boolean isNotValid(int x, int y, int m, int n) {
        return x < 0 || x > m - 1 || y < 0 || y > n - 1;
    }

    public static void main(String[] args) {

        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };;
        System.out.println(orangesRotting(grid));

    }

}
