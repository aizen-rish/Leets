package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 200
 * Problem link : https://leetcode.com/problems/number-of-islands
 * 
 * Date Attempted: 27/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class IslandCount {

    private static final int[][] MOVES = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    record Pair(int x, int y) {
    }

    public static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void bfs(char[][] grid, int i, int j) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        grid[i][j] = '0';

        while (!q.isEmpty()) {
            Pair node = q.poll();
            for (Pair next : nextNodes(grid, node.x, node.y)) {
                grid[next.x][next.y] = '0';
                q.add(next);
            }
        }
    }

    private static List<Pair> nextNodes(char[][] grid, int i, int j) {

        List<Pair> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int[] move : MOVES) {
            int x = move[0] + i;
            int y = move[1] + j;
            if (!isNotValid(x, y, m, n) && grid[x][y] == '1') {
                ans.add(new Pair(x, y));
            }
        }

        return ans;
    }

    private static boolean isNotValid(int x, int y, int m, int n) {
        return x < 0 || x > m - 1 || y < 0 || y > n - 1;
    }

    public static void main(String[] args) {

        char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        System.out.println(numIslands(grid));
    }

}
