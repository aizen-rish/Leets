package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: 646
 * Problem link: https://leetcode.com/problems/maximum-length-of-pair-chain/
 * 
 * Date Attempted: 26/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LongestChain {

    public static int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[pairs.length + 1];
        Arrays.fill(dp, -1);

        return chainInternal(pairs, dp, 0);
    }

    private static int chainInternal(int[][] pairs, int[] dp, int i) {

        if (i >= pairs.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int exclude = chainInternal(pairs, dp, i + 1);

        int include = 1;

        // find next suitable pair
        int k = search(pairs, i);
        if (k != -1) {
            include += chainInternal(pairs, dp, k);
        }

        dp[i] = Math.max(include, exclude);
        return dp[i];
    }

    private static int search(int[][] pairs, int i) {

        int ans = -1;
        int key = pairs[i][1];

        int left = i + 1;
        int right = pairs.length - 1;

        while (left <= right) {

            int mid = right - (right - left) / 2;

            if (pairs[mid][0] > key) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] arr = { { 1, 2 }, { 3, 6 }, { 7, 8 }, { 3, 4 } };

        System.out.println(findLongestChain(arr));
    }

}
