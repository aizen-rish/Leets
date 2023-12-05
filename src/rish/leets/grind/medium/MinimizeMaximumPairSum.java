package rish.leets.grind.medium;

import java.util.Arrays;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1877
 * 
 * Problem link:
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 * 
 * Date Attempted: 17/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MinimizeMaximumPairSum {

    public int minPairSum(int[] nums) {

        Arrays.sort(nums);

        int len = nums.length;
        int i = 0;
        int j = len - 1;

        int max = 0;
        while (i < j) {
            max = Math.max(max, nums[i] + nums[j]);
            i++;
            j--;
        }

        return max;
    }

}
