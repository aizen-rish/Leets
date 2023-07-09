package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 542
 * Problem link: https://leetcode.com/problems/01-matrix/
 * 
 * Date Attempted: 09/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class NearestNeighbourMatrix {

    class Node {

        int x;
        int y;
        int level;

        public Node(int x, int y, int level) {
            super();
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    private final int[][] neighbours = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // create new array
        int[][] ans = new int[m][n];

        boolean[][] visited = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            int[] js = mat[i];
            for (int j = 0; j < js.length; j++) {
                if (js[j] == 0) {
                    ans[i][j] = 0;
                    visited[i][j] = true;
                    q.add(new Node(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {

            Node curr = q.poll();
            int level = curr.level;

            for (int[] side : generateNeighbours(curr.x, curr.y)) {

                int nRow = side[0];
                int nCol = side[1];
                if (isInvalid(nRow, nCol, m, n) || visited[nRow][nCol]) {
                    continue;
                }

                ans[nRow][nCol] = level + 1;
                visited[nRow][nCol] = true;

                q.add(new Node(nRow, nCol, level + 1));
            }
        }

        return ans;
    }

    private int[][] generateNeighbours(int x, int y) {
        int[][] answ = new int[4][2];
        int i = 0;
        for (int[] direction : neighbours) {
            int row = x + direction[0];
            int col = y + direction[1];
            answ[i++] = new int[] { row, col };
        }
        return answ;
    }

    private boolean isInvalid(int x, int y, int rows, int cols) {
        return x < 0 || x >= rows || y < 0 || y >= cols;
    }

    public static void main(String[] args) {

        int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        NearestNeighbourMatrix updater = new NearestNeighbourMatrix();
        System.out.println(Arrays.deepToString(updater.updateMatrix(arr)));
    }

}
