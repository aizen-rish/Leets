package rish.leets.grind.medium;

/**
 * Daily Challenge!
 * 
 * Problem #: LC2849
 * 
 * Problem link:
 * https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
 * 
 * Date Attempted: 08/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ReachCellTime {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {

        int xdiff = Math.abs(sx - fx);
        int ydiff = Math.abs(sy - fy);

        int dist = Math.max(xdiff, ydiff);

        if (t < 2) {
            return dist == t;
        }

        return dist <= t;
    }

}
