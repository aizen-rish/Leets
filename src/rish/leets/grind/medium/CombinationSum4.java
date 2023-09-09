package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC377
 * Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Date Attempted: 09/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CombinationSum4 {

    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return combInternal(nums, target, dp);
    }

    private static int combInternal(int[] nums, int target, int[] dp) {

        if (dp[target] != -1) {
            return dp[target];
        }

        if (target == 0) {
            return 1;
        }

        if (target < nums[0]) {
            return 0;
        }

        int count = 0;
        for (int num : nums) {
            if (target - num < 0) {
                break;
            }
            count += combInternal(nums, target - num, dp);
        }

        dp[target] = count;
        return count;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5 };

        System.out.println(combinationSum4(arr, 8));

    }

}
