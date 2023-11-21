package rish.leets.grind.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1814
 * 
 * Problem link: https://leetcode.com/problems/count-nice-pairs-in-an-array/
 * 
 * Date Attempted: 21/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CountNicePairsInArray {

    private static int MOD = 1000000007;

    public int countNicePairs(int[] nums) {

        Map<Integer, Integer> feq = new HashMap<>();
        for (int a : nums) {
            int diff = a - reverse(a);
            feq.compute(diff, (k, v) -> v == null ? 1 : v + 1);
        }

        int ans = 0;
        for (int val : feq.values()) {
            int comb = (int) (comb(val, 2) % MOD);
            ans = (ans + comb) % MOD;
        }

        return ans;
    }

    private int reverse(int num) {

        int ans = 0;
        while (num > 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;
        }

        return ans;
    }

    private long comb(int n, int r) {

        if (r > n) {
            return 0;
        }

        if (r == 0 || n == r) {
            return 1;
        }

        if (r == 1) {
            return n;
        }

        long sum = 1;
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }

        return sum;
    }

}
