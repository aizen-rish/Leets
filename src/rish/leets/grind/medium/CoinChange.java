package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: 322
 * Problem link : https://leetcode.com/problems/coin-change/
 * 
 * Date Attempted: 19/07/2022
 * 
 * @author Rishabh Soni
 *
 */
public class CoinChange {

    /*
     * Greedy approach: Doesn't work for all cases
     */
    public static int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);

        int total = amount;
        int count = 0;

        int i = coins.length - 1;
        while (i >= 0) {

            int coin = coins[i];

            if (total < coin) {
                i--;
                continue;
            }

            while (total >= coin) {
                total -= coin;
                count++;
            }

            if (total == 0) {
                return count;
            }

            i--;
        }

        if (total == 0) {
            return count;
        }

        return -1;
    }

    public static int coinChange2(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return coinChangeInternal(coins, amount, map);
    }

    /*
     * Dynamic programming: Top-down approach (recursion)
     */
    public static int coinChangeInternal(int[] coins, int amount, Map<Integer, Integer> map) {

        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int cc = -1;
        int i = coins.length - 1;

        while (i >= 0) {

            int coin = coins[i];
            int count = coinChangeInternal(coins, amount - coin, map);
            if (count >= 0) {
                cc = cc >= 0 ? Math.min(cc, count + 1) : count + 1;
            }
            i--;
        }

        map.put(amount, cc);
        return cc;
    }

    /*
     * Dynamic programming: Bottom-up approach (iteration)
     */
    public static int coinChange3(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 4, 3, 5 };
        System.out.println(coinChange3(coins, 19));
    }

}
