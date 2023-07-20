package rish.leets.contests.weekly;

import java.util.Arrays;

/*
 *            Weekly Contest 354
 * 
 * Problem #: 2779
 * Problem link:https://leetcode.com/problems/number-of-beautiful-pairs 
 * Contest link: https://leetcode.com/contest/weekly-contest-354/
 * 
 * Date Attempted: 16/07/2023
 * 
 * @author Rishabh Soni
 * 
 */
public class MaximumBeauty {

    public int maximumBeauty(int[] nums, int k) {

        Arrays.sort(nums);

        int start = 0;
        int end = 0;
        while (start < nums.length && end < nums.length) {
            if (nums[end] - nums[start] > 2 * k) {
                start++;
            }
            end++;
        }

        return end - start;
    }

}
