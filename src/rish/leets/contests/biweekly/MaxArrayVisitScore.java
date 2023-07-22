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

    public long maxScore(int[] nums, int x) {

        long[] dp = new long[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int j = nums[i];
            boolean parity = isEven(nums[i - 1]) == isEven(j);

            if (parity) {
                dp[i] = dp[i - 1] + j;
            } else {
                dp[i] = j;
            }
        }

        return dp[0];
    }

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static void main(String[] args) {

    }

}
