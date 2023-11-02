package rish.leets.grind.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1356
 * Problem link: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 * 
 * Date Attempted: 30/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class VowelPermutationcount {

    enum VOWEL {

        a(0), e(1), i(2), o(3), u(4);

        public final int index;

        private VOWEL(int i) {
            this.index = i;
        }
    };

    private static int MOD = 1000000007;
    private static Map<VOWEL, List<VOWEL>> ADJ_LIST = new HashMap<>();

    static {
        ADJ_LIST.put(VOWEL.a, Arrays.asList(VOWEL.e));
        ADJ_LIST.put(VOWEL.e, Arrays.asList(VOWEL.a, VOWEL.i));
        ADJ_LIST.put(VOWEL.i, Arrays.asList(VOWEL.a, VOWEL.e, VOWEL.o, VOWEL.u));
        ADJ_LIST.put(VOWEL.o, Arrays.asList(VOWEL.i, VOWEL.u));
        ADJ_LIST.put(VOWEL.u, Arrays.asList(VOWEL.a));
    }

    public static int countVowelPermutation(int n) {

        int[][] dp = new int[VOWEL.values().length][n];

        int total = 0;
        for (VOWEL v : VOWEL.values()) {
            total = (total + dfs(v, 1, n, dp)) % MOD;
        }

        return total;
    }

    private static int dfs(VOWEL node, int i, int n, int[][] dp) {

        System.out.println(node + " " + i);

        if (i == n) {
            return 1;
        }

        if (dp[node.index][i] != 0) {
            return dp[node.index][i];
        }

        int total = 0;
        for (VOWEL v : ADJ_LIST.get(node)) {
            total = (total + dfs(v, i + 1, n, dp)) % MOD;
        }

        dp[node.index][i] = total % MOD;

        return total;
    }

    public int countVowelPermutation2(int n) {

        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;

        for (int j = 1; j < n; j++) {

            long next_a = e;
            long next_e = (a + i) % MOD;
            long next_i = (a + e + o + u) % MOD;
            long next_o = (i + u) % MOD;
            long next_u = a;

            a = next_a;
            e = next_e;
            i = next_i;
            o = next_o;
            u = next_u;
        }

        return (int) ((a + e + i + o + u) % MOD);
    }

    public static void main(String[] args) {

        System.out.println(countVowelPermutation(144));

    }

}
