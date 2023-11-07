package rish.leets.grind.medium;

/**
 * Practice Prep - 150
 * 
 * Problem #: LC122
 * 
 * Problem link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * Date Attempted: 07/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class BestTimeToSellStocks2 {

    public int maxProfit(int[] prices) {

        int len = prices.length - 1;
        if (len == 0) {
            return 0;
        }

        int profit = 0;

        int i = 0;
        while (i < len) {

            int m = i;
            while (m < len && prices[m + 1] <= prices[m]) {
                m++;
            }

            int n = m;
            while (n < len && prices[n + 1] > prices[n]) {
                n++;
            }

            profit += prices[n] - prices[m];
            i = n;
        }

        return profit;
    }

}
