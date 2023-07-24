package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Daily Challenge!
 * 
 * Problem #: 688
 * Problem link: https://leetcode.com/problems/knight-probability-in-chessboard/
 * 
 * Date Attempted: 22/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class KnightProbability {

    private static final int[][] KNIGHT_MOVES = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 },
            { -1, -2 }, { -1, 2 } };

    public static double knightProbability(int n, int k, int row, int column) {

        if (k == 0) {
            return 1;
        }

        return possibleMoves(n, row, column, k);
    }

    private static double possibleMoves(int size, int row, int col, int k) {

        double[][] dp = new double[size][size];

        dp[row][col] = 1;

        for (int t = 0; t < k; t++) {

            double[][] updatedDp = new double[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (List<Integer> mv : nextPossibleMoves(size, i, j)) {
                        int ni = mv.get(0);
                        int nj = mv.get(1);
                        updatedDp[i][j] += dp[ni][nj] / 8.0;
                    }
                }
            }

            System.out.println(Arrays.deepToString(updatedDp));
            dp = updatedDp;
        }

        return Arrays.stream(dp).mapToDouble(x -> Arrays.stream(x).sum()).sum();
    }

    private static List<List<Integer>> nextPossibleMoves(int size, int row, int col) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] move : KNIGHT_MOVES) {
            int x = move[0] + row;
            int y = move[1] + col;
            if (!isNotValid(x, y, size)) {
                ans.add(Arrays.asList(x, y));
            }
        }

        return ans;
    }

    private static boolean isNotValid(int x, int y, int n) {
        return x < 0 || x > n - 1 || y < 0 || y > n - 1;
    }

    public static void main(String[] args) {
        System.out.println(knightProbability(3, 1, 0, 0));
    }

}
