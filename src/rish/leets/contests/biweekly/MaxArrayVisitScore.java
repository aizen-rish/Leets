package rish.leets.contests.biweekly;

/*
 *        BiWeekly Contest 109
 * 
 * Problem #: 2786
 * Contest link: https://leetcode.com/contest/biweekly-contest-109/
 * Problem link: https://leetcode.com/problems/visit-array-positions-to-maximize-score/
 * 
 * Attempt Date: 22/07/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class MaxArrayVisitScore {

    /*
     * Optimized for space
     */
    public static long maxScore(int[] nums, int x) {

        long[] dp = new long[2];
        long sum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {

            int j = nums[i] % 2;
            sum = nums[i] + Math.max(0, Math.max(dp[j], dp[1 - j] - x));
            dp[j] = Math.max(dp[j], sum);
        }

        return sum;
    }

    /*
     * Unoptimized
     */
    public static long maxScore2(int[] nums, int x) {

        int len = nums.length;

        long[][] dp = new long[len + 1][2];
        long sum = nums[0];

        dp[len][0] = 0;
        dp[len][1] = 0;

        for (int i = len - 1; i >= 1; i--) {

            int j = nums[i] % 2;

            long take = nums[i] + dp[i + 1][j];

            dp[i][j] = Math.max(take, dp[i + 1][j]);
            dp[i][1 - j] = Math.max(take - x, dp[i + 1][1 - j]);
        }

        return sum + dp[1][nums[0] % 2];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 1, 9, 2 };
        System.out.println(maxScore2(arr, 5));
    }

}
