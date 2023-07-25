package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 56
 * Problem link : https://leetcode.com/problems/merge-intervals/
 * 
 * Date Attempted: 25/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> answer = new ArrayList<>();

        int[] prev = intervals[0];

        for (int[] interval : intervals) {

            if (isOverlapping(prev, interval)) {
                answer.remove(prev);
                prev = new int[] { prev[0], Math.max(interval[1], prev[1]) };
            } else {
                prev = interval;
            }

            answer.add(prev);
        }

        return answer.toArray(new int[answer.size()][2]);
    }

    private static boolean isOverlapping(int[] source, int[] query) {
        return source[0] <= query[1] && source[1] >= query[0];
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(Arrays.deepToString(merge(arr)));
    }

}
