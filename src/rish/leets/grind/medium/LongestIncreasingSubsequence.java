package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: 673
 * Problem link: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * 
 * Date Attempted: 21/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LongestIncreasingSubsequence {

    public static int findNumberOfLIS(int[] nums) {

        int len = nums.length;

        int[] dp = new int[len];

        for (int i = len - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) { // add to subsequence
                dp[i] = 1 + dp[i + 1];
                continue;
            }

            // remove previous from subsequence
            if (i + 2 < len && nums[i] < nums[i + 2]) {
                dp[i] = 1 + dp[i + 2];
                continue;
            }

            dp[i] = 1;
        }

        int[] lengthDP = new int[len];
        int[] countDP = new int[len];
        Arrays.fill(lengthDP, 1);
        Arrays.fill(countDP, 1);

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) { // add to subsequence

                    if (lengthDP[j] + 1 > lengthDP[i]) {
                        lengthDP[i] = 1 + lengthDP[j];
                        countDP[i] = 0;
                    }

                    if (lengthDP[i] == lengthDP[j] + 1) {
                        countDP[i] += countDP[j];
                    }
                }
            }
        }

        int LIS = Arrays.stream(lengthDP).max().getAsInt();

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (lengthDP[i] == LIS) {
                ans += countDP[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 7 };
        System.out.println(findNumberOfLIS(arr));
    }

}
