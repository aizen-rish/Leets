package rish.leets.contests.biweekly;

/*
 *        BiWeekly Contest 109
 * 
 * Problem #: 2787
 * Contest link: https://leetcode.com/contest/biweekly-contest-109/
 * Problem link: https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers
 * 
 * Attempt Date: 25/07/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class WaysOfSumOfPowers {

    private static int MOD = 1000000007;
    private static Integer[][] dp;

    public static int numberOfWays(int n, int x) {
        dp = new Integer[301][301];
        return numberOfWays(n, x, 1);
    }

    public static int numberOfWays(int n, int x, int i) {

        if (i > 300) {
            return 0;
        }

        Integer dpVal = dp[i][n];
        if (dpVal != null) {
            return dpVal;
        }

        int res = (int) Math.pow(i, x);

        if (res == n) {
            return 1;
        }

        if (res > n) {
            return 0;
        }

        int ans = 0;
        ans += numberOfWays(n - res, x, i + 1); // Take or consider i
        ans += numberOfWays(n, x, i + 1); // Not take i

        dp[i][n] = ans % MOD;
        return ans % MOD;
    }

    public static void main(String[] args) {
        System.out.print(numberOfWays(213, 1));
    }

}
