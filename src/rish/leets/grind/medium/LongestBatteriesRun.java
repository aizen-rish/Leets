package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: 2141
 * Problem link: https://leetcode.com/problems/maximum-running-time-of-n-computers/
 * 
 * Date Attempted: 27/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LongestBatteriesRun {

    public long maxRunTime(int n, int[] batteries) {

        Arrays.sort(batteries);

        int m = batteries.length;
        if (m == n || m == 1) {
            return batteries[0];
        }

        // first m-n batteries are extra
        long ans = 0;
        for (int i = 0; i < m - n; i++) {
            ans += batteries[i];
        }

        int[] comps = Arrays.copyOfRange(batteries, m - n, m);
        for (int i = 0; i < n - 1; i++) {
            long diff = (long) (i + 1) * (comps[i + 1] - comps[i]);
            if (diff > ans) {
                return comps[i] + (ans / (i + 1));
            }
            ans -= diff;
        }

        return comps[n - 1] + (ans / n);
    }

    public static long maxRunTime2(int n, int[] batt) {

        long sum = Arrays.stream(batt).sum();

        long left = 1;
        long right = (long) Math.ceil(sum / n * 1.0);

        long ans = -1;

        while (left <= right) {

            long mid = right - (right - left) / 2;

            long midSum = 0;
            for (int x : batt) {
                midSum += Math.min(x, mid);
            }

            if (midSum >= mid * n) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 1 };

        System.out.println(maxRunTime2(2, arr));

    }

}
