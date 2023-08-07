package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: 486
 * Problem link: https://leetcode.com/problems/predict-the-winner/
 * 
 * Date Attempted: 28/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class PredictWinner {

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        Integer[][] dp = new Integer[len][len];
        return maxScore(nums, 0, len - 1, dp) >= 0;
    }

    private int maxScore(int[] nums, int start, int end, Integer[][] dp) {

        // Only one element left
        if (start == end) {
            dp[start][end] = nums[start];
            return nums[start];
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int L = nums[start] - maxScore(nums, start + 1, end, dp);
        int R = nums[end] - maxScore(nums, start, end - 1, dp);

        dp[start][end] = Math.max(L, R);
        return dp[start][end];
    }

}
