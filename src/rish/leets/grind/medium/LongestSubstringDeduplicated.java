package rish.leets.grind.medium;

import java.util.HashSet;
import java.util.Set;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: 3
 * Problem link:  https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Date Attempted: 14/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LongestSubstringDeduplicated {

    public static int lengthOfLongestSubstring(String s) {

        char[] c = s.toCharArray();
        Set<Character> usedChars = new HashSet<>();

        int left = 0;
        int overallMax = 0;

        for (int i = 0; i < c.length; i++) {

            if (!usedChars.contains(c[i])) {
                usedChars.add(c[i]);
            } else {
                while (c[left] != c[i]) {
                    usedChars.remove(c[left++]);
                }
                usedChars.remove(c[left++]);
                usedChars.add(c[i]);
            }
            overallMax = Math.max(overallMax, usedChars.size());
        }

        return overallMax;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

}
