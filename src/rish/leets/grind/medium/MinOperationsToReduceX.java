package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1658
 * Problem link: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * 
 * Date Attempted: 20/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MinOperationsToReduceX {

    public int minOperations(int[] nums, int x) {

        int sum = Arrays.stream(nums).sum();
        int target = sum - x;

        if (target == 0) {
            return nums.length;
        }

        int max = 0;
        int curSum = 0;

        int left = 0;
        int right = 0;
        while (right < nums.length) {

            curSum += nums[right];
            while (curSum > target && left <= right) {
                curSum -= nums[left];
                left++;
            }

            if (curSum == target) {
                max = Math.max(max, right - left + 1);
            }

            right++;
        }

        return max > 0 ? nums.length - max : -1;
    }

}
