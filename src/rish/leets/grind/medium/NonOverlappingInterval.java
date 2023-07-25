package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: 435
 * Problem link: https://leetcode.com/problems/non-overlapping-intervals/
 * 
 * Date Attempted: 19/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class NonOverlappingInterval {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prev = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
            } else {
                count++;
            }
        }

        return count;
    }

}
