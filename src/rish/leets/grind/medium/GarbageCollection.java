package rish.leets.grind.medium;

/**
 * Daily Challenge!
 * 
 * Problem #: LC2391
 * 
 * Problem link:
 * https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
 * 
 * Date Attempted: 20/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class GarbageCollection {

    public int garbageCollection(String[] garbage, int[] travel) {

        int len = garbage.length;

        boolean foundP = false;
        boolean foundM = false;
        boolean foundG = false;

        int ans = 0;

        for (int i = len - 1; i >= 0; i--) {

            ans += garbage[i].length();

            foundP |= garbage[i].contains("P");
            foundG |= garbage[i].contains("G");
            foundM |= garbage[i].contains("M");

            if (foundP && i > 0) {
                ans += travel[i - 1];
            }

            if (foundM && i > 0) {
                ans += travel[i - 1];
            }

            if (foundG && i > 0) {
                ans += travel[i - 1];
            }
        }

        return ans;
    }

}
