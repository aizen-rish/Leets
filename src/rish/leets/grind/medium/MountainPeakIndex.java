package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: 852
 * Problem link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * 
 * Date Attempted: 25/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MountainPeakIndex {

    public static int peakIndexInMountainArray(int[] arr) {

        if (arr.length == 3) {
            return 1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left - (left - right) / 2;

            int peak = arr[mid];
            int lPeak = arr[mid - 1];
            int rPeak = arr[mid + 1];

            if (lPeak > peak) {
                right = mid;
                continue;
            }

            if (peak < rPeak) {
                left = mid;
                continue;
            }

            return mid;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 3, 2, 0 };
        System.out.println(peakIndexInMountainArray(arr));
    }

}
