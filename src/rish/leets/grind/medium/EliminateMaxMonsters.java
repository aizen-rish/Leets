package rish.leets.grind.medium;

import java.util.Arrays;

/**
 * Daily Challenge!
 * 
 * Problem #: LC11921
 * 
 * Problem link:
 * https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
 * 
 * Date Attempted: 07/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class EliminateMaxMonsters {

    public int eliminateMaximum(int[] dist, int[] speed) {

        int len = dist.length;
        if (len == 1) {
            return 1;
        }

        double[] time = new double[len];
        for (int i = 0; i < len; i++) {
            time[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(time);

        int i = 1;
        while (i < len && time[i] > i) {
            i++;
        }

        return i;
    }

}
