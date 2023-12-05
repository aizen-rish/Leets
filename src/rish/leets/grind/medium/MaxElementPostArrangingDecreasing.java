package rish.leets.grind.medium;

import java.util.Arrays;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1846
 * 
 * Problem link:
 * https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 * 
 * Date Attempted: 15/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MaxElementPostArrangingDecreasing {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);

        int prev = 1;
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if (diff > 1) {
                arr[i] = prev + 1;
            }
            prev = arr[i];
        }

        return arr[arr.length - 1];
    }

    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {

        Arrays.sort(arr);

        int prev = 0;
        for (int a : arr) {
            prev = Math.min(a, prev + 1);
        }

        return prev;
    }

}
