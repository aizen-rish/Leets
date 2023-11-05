package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1503
 * 
 * Problem link:
 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 * 
 * Date Attempted: 04/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class AntFalloutMoment {

    public int getLastMoment(int n, int[] left, int[] right) {

        OptionalInt rightMostAnt = Arrays.stream(right).min();
        int rightDist = -1;
        if (rightMostAnt.isPresent()) {
            rightDist = n - rightMostAnt.getAsInt();
        }

        OptionalInt leftMostAnt = Arrays.stream(left).max();
        int leftDist = -1;
        if (leftMostAnt.isPresent()) {
            leftDist = leftMostAnt.getAsInt();
        }

        return Math.max(rightDist, leftDist);
    }

    public int getLastMoment2(int n, int[] left, int[] right) {

        int maxTime = 0;
        for (int ant : left) {
            maxTime = Math.max(maxTime, ant);
        }

        for (int ant : right) {
            maxTime = Math.max(maxTime, n - ant);
        }

        return maxTime;
    }

}
