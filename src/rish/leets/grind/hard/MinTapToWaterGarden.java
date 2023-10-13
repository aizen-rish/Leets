package rish.leets.grind.hard;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1326
 * Problem link: https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * 
 * Date Attempted: 31/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MinTapToWaterGarden {

    public static int minTaps(int n, int[] ranges) {

        int[] jumps = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            int j = ranges[i];
            int start = Math.max(0, i - j);
            int end = Math.min(n, i + j);
            jumps[start] = Math.max(jumps[start], end);
        }

        int currReach = 0;
        int maxReach = 0;
        int ans = 0;

        for (int i = 0; i < n + 1; i++) {

            if (i > maxReach) {
                return -1;
            }

            if (i > currReach) {
                ans++;
                currReach = maxReach;
            }

            maxReach = Math.max(maxReach, jumps[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 0, 0, 0 };

        System.out.println(minTaps(3, arr));
    }

}
