package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: LC5
 * Problem link: https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * Date Attempted: 27/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];

        int x = 0;
        int y = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                x = i;
                y = i + 1;
            }
        }

        for (int diff = 2; diff < len; diff++) {
            for (int i = 0; i < len - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    x = i;
                    y = j;
                }
            }
        }

        return s.substring(x, y + 1);
    }
}
