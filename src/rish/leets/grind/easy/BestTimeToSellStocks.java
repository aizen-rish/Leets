package rish.leets.grind.easy;

/**
 * Practice Prep - 150
 * 
 * Problem #: LC121
 * 
 * Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Date Attempted: 06/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class BestTimeToSellStocks {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len == 1) {
            return 0;
        }

        int m = 0;
        int n = 1;

        int ans = 0;
        while (n < len) {

            int profit = prices[n] - prices[m];
            ans = Math.max(ans, profit);

            if (profit < 0) {
                m = n;
            }

            n++;
        }

        return ans;
    }

}
