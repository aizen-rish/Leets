package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC81
 * Problem link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Date Attempted: 10/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SearchRotatedArray2 {

    public boolean search(int[] nums, int target) {

        int size = nums.length;
        if (size == 1) {
            return nums[0] == target;
        }

        // check if already sorted
        int lastVal = nums[size - 1];
        if (lastVal > nums[0]) {
            return Arrays.binarySearch(nums, target) >= 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, left, nums[mid])) {
                left++;
                continue;
            }

            boolean pivotArray = existsInFirst(nums, left, nums[mid]);
            boolean targetArray = existsInFirst(nums, left, target);

            if (pivotArray != targetArray) {
                if (pivotArray) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    private static boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    private static boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }

}
