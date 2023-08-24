package rish.leets.contests.weekly;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *        Weekly Contest 359
 * 
 * Problem #: 2830
 * Problem link: https://leetcode.com/problems/maximize-the-profit-as-the-salesman/
 * 
 * Attempt Date: 24/08/2023
 * 
 * @author: Rishabh Soni
 * 
 */
public class MaxProfitSellingHouse {

    public static int maximizeTheProfit(int n, List<List<Integer>> offers) {

        Collections.sort(offers, (a, b) -> a.get(0) - b.get(0));

        int[] dp = new int[offers.size() + 1];
        Arrays.fill(dp, -1);

        return solve(0, offers, dp);
    }

    private static int solve(int i, List<List<Integer>> offers, int[] dp) {

        if (i >= offers.size()) {
            return -1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int exclude = solve(i + 1, offers, dp);

        int include = offers.get(i).get(2);

        // find next non-overlapping offer
        int k = search(i, offers);
        if (k != -1) {
            include += solve(k, offers, dp);
        }

        dp[i] = Math.max(exclude, include);
        return dp[i];
    }

    private static int search(int i, List<List<Integer>> offers) {

        int key = offers.get(i).get(1);
        int ans = -1;

        int left = i;
        int right = offers.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (offers.get(mid).get(0) > key) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        List<List<Integer>> offers = Arrays.asList(Arrays.asList(1, 3, 9), Arrays.asList(0, 2, 10),
                Arrays.asList(1, 3, 3), Arrays.asList(0, 1, 3), Arrays.asList(2, 2, 1), Arrays.asList(3, 3, 7),
                Arrays.asList(2, 2, 1), Arrays.asList(1, 2, 9), Arrays.asList(1, 2, 8));

        System.out.println(maximizeTheProfit(4, offers));
    }

}
