package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 75
 * Problem link : https://leetcode.com/problems/sort-colors/
 * 
 * Date Attempted: 28/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SortColors {

    public static void sortColors(int[] nums) {

        int len = nums.length;

        int blue = len - 1;
        int white = 0;
        int red = 0;

        int oneCount = 0;

        for (int x : nums) {
            if (x == 2) {
                nums[blue--] = x;
            } else if (x == 1) {
                nums[white++] = x;
                oneCount++;
            } else {
                if (nums[red] == 1) {
                    shift(nums, red, oneCount);
                }
                nums[red++] = x;
                white++;
            }
        }
    }

    private static void shift(int[] arr, int m, int count) {
        for (int i = m; i < m + count; i++) {
            arr[i + 1] = arr[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = { 2, 0, 1 };
        sortColors(arr);

        System.out.println(Arrays.toString(arr));
    }

}
