package rish.leets.grind.easy;

/*
 * Daily Challenge!
 * 
 * Problem #: LC338
 * Problem link: https://leetcode.com/problems/counting-bits/
 * 
 * Date Attempted: 01/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CountingBits {

    public int[] countBits(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + i % 2;
        }

        return dp;
    }

}
