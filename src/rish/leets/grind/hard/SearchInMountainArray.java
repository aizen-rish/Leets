package rish.leets.grind.hard;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1095
 * Problem link: https://leetcode.com/problems/find-in-mountain-array/
 * 
 * Date Attempted: 12/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SearchInMountainArray {

    public static int findInMountainArray(int target, int[] arr) {

        int peakIndex = findPeak(arr);
        if (arr[peakIndex] == target) {
            return peakIndex;
        }

        System.out.println(peakIndex);

        // binary search in first part of index
        int left = binarySearch(arr, 0, peakIndex, target, true);

        if (left != -1) {
            return left;
        }

        return binarySearch(arr, peakIndex, arr.length, target, false);
    }

    private static int binarySearch(int[] arr, int start, int end, int target, boolean isAsc) {

        int left = start;
        int right = end - 1;

        while (left <= right) {

            int mid = left - (left - right) / 2;
            int ele = arr[mid];

            if (ele == target) {
                return mid;
            }

            if (ele > target) {
                if (isAsc) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (isAsc) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int findPeak(int[] arr) {

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
        int[] arr = { 1, 5, 2 };
        System.out.println(findInMountainArray(2, arr));
    }

}
