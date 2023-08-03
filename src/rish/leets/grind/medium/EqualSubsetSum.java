package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 416
 * Problem link: https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * Date Attempted: 03/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class EqualSubsetSum {

    public static boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int x : nums) {
            // dp[i] is true there exists dp[i-x]
            for (int i = target; i >= x; i--) {
                dp[i] |= dp[i - x];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int arr[] = { 2, 2, 1, 1 };

        System.out.println(canPartition(arr));

    }

}
