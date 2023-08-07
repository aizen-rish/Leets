package rish.leets.grind.medium;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 33
 * Problem link : https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Date Attempted: 26/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SearchRotatedArray {

    public static int search(int[] nums, int target) {

        int size = nums.length;

        if (size == 1) {
            return nums[0] == target ? 0 : -1;
        }

        // check if already sorted
        if (nums[size - 1] > nums[0]) {
            return customBinarySearch(nums, 0, size, target);
        }

        int left = 0;
        int right = size - 1;

        while (left <= right) {

            int mid = left - (left - right) / 2;
            int val = nums[mid];

            if (nums[size - 1] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int start = target >= nums[0] ? 0 : left;
        int end = target >= nums[0] ? left : size;

        return customBinarySearch(nums, start, end, target);
    }

    private static int customBinarySearch(int[] arr, int start, int end, int target) {

        int left = start;
        int right = end - 1;

        while (left <= right) {

            int mid = left - (left - right) / 2;
            int val = arr[mid];

            if (val > target) {
                right = mid - 1;
            } else if (val < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3 };
        System.out.println(search(arr, 5));
    }

}
