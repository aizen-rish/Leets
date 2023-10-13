package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Daily Challenge!
 * 
 * Problem #: LC2707
 * Problem link: https://leetcode.com/problems/extra-characters-in-a-string/
 * 
 * Date Attempted: 02/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MinExtraChars {

    public static int minExtraChar(String s, String[] dictionary) {

        int len = s.length();

        boolean[] visited = new boolean[len];

        for (String word : dictionary) {

            int j = 0;
            for (int i = 0; i < len; i++) {

                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                } else {
                    j = 0;
                }

                if (j == word.length()) {
                    System.out.println(word + " " + i);
                    Arrays.fill(visited, i - word.length() + 1, i + 1, true);
                    break;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                ans++;
            }
        }

        return ans;
    }

    public static int minExtraChar2(String s, String[] dictionary) {

        int len = s.length();
        int[] dp = new int[len + 1];

        Arrays.fill(dp, -1);

        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));

        return minInternal(s, 0, dict, dp);
    }

    private static int minInternal(String s, int i, Set<String> dict, int[] dp) {

        int len = s.length();

        if (i == len) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int exclude = 1 + minInternal(s, i + 1, dict, dp);

        int include = len;

        for (int j = i; j < len; j++) {
            String word = s.substring(i, j + 1);
            if (dict.contains(word)) {
                include = Math.min(include, minInternal(s, j + 1, dict, dp));
            }
        }

        dp[i] = Math.min(exclude, include);
        return dp[i];
    }

    public static void main(String[] args) {

        String s = "dwmodizxvvbosxxw";
        String[] dict = { "ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz",
                "ds", "kzbu" };

        System.out.println(minExtraChar2(s, dict));
    }

}
