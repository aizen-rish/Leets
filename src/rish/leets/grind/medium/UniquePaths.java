package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC62
 * Problem link: https://leetcode.com/problems/unique-paths/
 * 
 * Date Attempted: 03/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return uniquePathInternal(0, 0, m, n, dp);
    }

    private int uniquePathInternal(int i, int j, int m, int n, int[][] dp) {

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int leftPaths = 0;
        if (i + 1 < m) {
            leftPaths = uniquePathInternal(i + 1, j, m, n, dp);
        }

        int rightPaths = 0;
        if (j + 1 < n) {
            rightPaths = uniquePathInternal(i, j + 1, m, n, dp);
        }

        dp[i][j] = leftPaths + rightPaths;
        return dp[i][j];
    }

}
