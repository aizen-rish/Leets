package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1048
 * Problem link: https://leetcode.com/problems/longest-string-chain/
 * 
 * Date Attempted: 23/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {

        Set<String> dict = new HashSet<>();
        Arrays.stream(words).forEach(e -> dict.add(e));

        Map<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            longestInternal(dict, word, dp);
        }

        return Collections.max(dp.values());
    }

    private int longestInternal(Set<String> dict, String word, Map<String, Integer> dp) {

        if (!dict.contains(word)) {
            return 0;
        }

        if (dp.containsKey(word)) {
            return dp.get(word);
        }

        int ans = 1;
        for (int i = 0; i < word.length(); i++) {
            String predsr = word.substring(0, i) + word.substring(i + 1);
            ans = Math.max(ans, 1 + longestInternal(dict, predsr, dp));
        }

        dp.put(word, ans);
        return ans;
    }

}
