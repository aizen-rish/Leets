package rish.leets.grind.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1930
 * 
 * Problem link:
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 * 
 * Date Attempted: 14/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class UniqueShortPalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {

        int[] first = new int[26];
        int[] second = new int[26];

        for (int i = 0; i < first.length; i++) {
            first[i] = -1;
            second[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first[c - 'a'] == -1) {
                first[c - 'a'] = i;
            } else {
                second[c - 'a'] = i;
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                Set<Character> set = new HashSet<>();
                for (int j = first[i] + 1; j < second[i]; j++) {
                    set.add(s.charAt(j));
                }
                ans += set.size();
            }
        }

        return ans;
    }

}
