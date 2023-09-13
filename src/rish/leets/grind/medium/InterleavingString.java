package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: 97
 * Problem link: https://leetcode.com/problems/interleaving-string/
 * 
 * Date Attempted: 25/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class InterleavingString {

    public static boolean isInterleaveGreedy(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        int i = 0;
        int j = 0;
        int x = 0;

        int m = 0;
        int n = 0;

        while (x < len3) {

            boolean isS1Used = false;
            while (i < len1 && s1.charAt(i) == s3.charAt(x)) {
                i++;
                x++;
                isS1Used |= true;
            }

            if (isS1Used) {
                m++;
            }

            boolean isS2Used = false;
            while (j < len2 && s2.charAt(j) == s3.charAt(x)) {
                j++;
                x++;
                isS2Used |= true;
            }

            if (isS2Used) {
                n++;
            }

            if (!isS1Used && !isS2Used) {
                break;
            }
        }

        if (Math.abs(m - n) > 1) {
            return false;
        }

        return x == len3;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int[] dps : dp) {
            Arrays.fill(dps, -1);
        }

        return isInterleaveInternal(s1, s2, s3, 0, 0, 0, dp) == 1;
    }

    public static int isInterleaveInternal(String s1, String s2, String s3, int i, int j, int x, int[][] dp) {

        if (x == s3.length()) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        boolean include = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(x)) {
            include |= isInterleaveInternal(s1, s2, s3, i + 1, j, x + 1, dp) == 1;
        }

        boolean exclude = false;
        if (j < s2.length() && s2.charAt(j) == s3.charAt(x)) {
            exclude |= isInterleaveInternal(s1, s2, s3, i, j + 1, x + 1, dp) == 1;
        }

        dp[i][j] = include || exclude ? 1 : 0;
        return dp[i][j];
    }

    public static void main(String[] args) {

        String s1 = "";
        String s2 = "";
        String s3 = "";

        System.out.println(isInterleave(s1, s2, s3));

    }

}
