package rish.leets.grind.hard;

/*
 * Daily Challenge!
 * 
 * Problem #: LC664
 * Problem link: https://leetcode.com/problems/strange-printer/
 * 
 * Date Attempted: 30/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class StrangePrinter {

    public int strangePrinter(String s) {

        int size = s.length();
        int dp[][] = new int[size][size];
        for (int length = 1; length <= size; length++) {
            for (int left = 0; left <= size - length; left++) {
                int right = left + length - 1;
                int j = -1;
                dp[left][right] = size;
                for (int i = left; i < right; i++) {
                    if (s.charAt(i) != s.charAt(right) && j == -1) {
                        j = i;
                    }
                    if (j != -1) {
                        dp[left][right] = Math.min(dp[left][right], 1 + dp[j][i] + dp[i + 1][right]);
                    }
                }

                if (j == -1) {
                    dp[left][right] = 0;
                }
            }
        }

        return dp[0][size - 1] + 1;
    }

}
