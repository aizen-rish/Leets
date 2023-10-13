package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC2616
 * Problem link: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
 * 
 * Date Attempted: 09/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MinimiseMaxDiffOfPairs {

    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);
        int size = nums.length;

        int left = 0;
        int right = nums[size - 1] - nums[0];

        int ans = 0;

        while (left <= right) {

            int mid = right - (right - left) / 2;

            if (countPairs(nums, mid) < p) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }

    private int countPairs(int[] arr, int max) {

        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] <= max) {
                count++;
                i++;
            }
        }

        return count;
    }

}
