package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.List;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 139
 * Problem link : https://leetcode.com/problems/word-break/
 * 
 * Date Attempted: 02/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        if (wordDict.contains(s)) {
            return true;
        }

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dpInternal(s, wordDict, dp, s.length() - 1);
    }

    private static boolean dpInternal(String s, List<String> wordDict, int[] dp, int i) {

        if (i < 0) {
            return true;
        }

        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        for (String word : wordDict) {

            int index = i - word.length() + 1;
            if (index < 0) {
                continue;
            }

            if (word.equals(s.substring(index, i + 1))) {
                if (dpInternal(s, wordDict, dp, i - word.length())) {
                    dp[i] = 1;
                    return true;
                }
            }
        }

        dp[i] = 0;
        return false;
    }

    /*
     * Unoptimised
     */
    private static boolean wordBreakInternal(String a, String b, List<String> memo) {

        if (memo.contains(a) && memo.contains(b)) {
            return true;
        }

        if (a == null || memo.contains(a)) {
            for (int i = 1; i < b.length(); i++) {
                if (wordBreakInternal(b.substring(0, i), b.substring(i), memo)) {

                    return true;
                }
            }
            return false;
        }

        if (b == null || memo.contains(b)) {
            for (int i = 1; i < a.length(); i++) {
                if (wordBreakInternal(a.substring(0, i), a.substring(i), memo)) {
                    return true;
                }
            }
            return false;
        }

        return false;
    }

    public static void main(String[] args) {

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
                "aaaaaaaaa", "aaaaaaaaaa");

        System.out.println(wordBreak(s, wordDict));
    }

}
