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

        int gTime = 0;
        int mTime = 0;
        int pTime = 0;

        for (int i = len - 1; i >= 0; i--) {

            for (char c : garbage[i].toCharArray()) {
                if (c == 'M') {
                    mTime++;
                } else if (c == 'P') {
                    pTime++;
                } else {
                    gTime++;
                }
            }

            if (i > 0) {
                gTime += gTime > 0 ? travel[i - 1] : 0;
                mTime += mTime > 0 ? travel[i - 1] : 0;
                pTime += pTime > 0 ? travel[i - 1] : 0;
            }
        }

        return gTime + mTime + pTime;
    }

}
