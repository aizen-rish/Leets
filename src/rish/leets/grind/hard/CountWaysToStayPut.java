package rish.leets.grind.hard;

import java.util.Arrays;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1269
 * 
 * Problem link:
 * https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 * 
 * Date Attempted: 15/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CountWaysToStayPut {

    private static int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps + 1][steps + 1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return numWaysInternal(0, steps, arrLen - 1, dp);
    }

    private int numWaysInternal(int curr, int remain, int limit, int[][] dp) {

        if (remain == 0) {
            return curr == 0 ? 1 : 0;
        }

        if (dp[curr][remain] != -1) {
            return dp[curr][remain];
        }

        int val = numWaysInternal(curr, remain - 1, limit, dp) % MOD;

        if (curr > 0) {
            val = (val + numWaysInternal(curr - 1, remain - 1, limit, dp)) % MOD;
        }

        if (curr < limit) {
            val = (val + numWaysInternal(curr + 1, remain - 1, limit, dp)) % MOD;
        }

        dp[curr][remain] = val;
        return val;
    }

}
