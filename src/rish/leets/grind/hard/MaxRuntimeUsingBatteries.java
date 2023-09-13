package rish.leets.grind.hard;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC2141
 * Problem link: https://leetcode.com/problems/maximum-running-time-of-n-computers/
 * 
 * Date Attempted: 27/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MaxRuntimeUsingBatteries {

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

}
