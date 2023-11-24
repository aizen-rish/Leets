package rish.leets.grind.medium;

import java.util.Arrays;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1561
 * 
 * Problem link:
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
 * 
 * Date Attempted: 24/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MaxCoinsFromPiles {

    public int maxCoins(int[] piles) {

        Arrays.sort(piles);

        int start = 0;
        int end = piles.length - 1;

        int ans = 0;

        while (start < end) {
            start++;
            end--;
            ans += piles[end--];
        }

        return ans;
    }

}
