package rish.leets.grind.medium;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 53
 * Problem link: https://leetcode.com/problems/maximum-subarray/
 * 
 * Date Attempted: 01/07/2023
 * 
 * @author Rishabh Soni
 * 
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {

        int cumSum = nums[0];
        int maxSum = nums[0];

        if (nums.length == 1) {
            return maxSum;
        }

        for (int i = 1; i < nums.length; i++) {
            cumSum = Math.max(nums[i], cumSum + nums[i]);
            maxSum = Math.max(cumSum, maxSum);
        }

        return maxSum;
    }

}
