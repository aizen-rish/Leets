package rish.leets.grind.medium;

import java.util.Arrays;

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

    public static void main(String[] args) {

        int[] coins = { 186, 419, 83, 408 };

        System.out.println(coinChange(coins, 6249));
    }

}
