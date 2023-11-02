package rish.leets.grind.hard;

/*
 * Daily Challenge!
 * 
 * Problem #: LC458
 * Problem link: https://leetcode.com/problems/poor-pigs/
 * 
 * Date Attempted: 29/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int test = minutesToTest / minutesToDie;

        int i = 0;
        while (Math.pow(test + 1, i) < buckets) {
            i++;
        }

        return i;
    }
}
