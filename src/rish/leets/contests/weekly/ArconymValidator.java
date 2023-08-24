package rish.leets.contests.weekly;

import java.util.Arrays;
import java.util.List;

/*
 *        Weekly Contest 359
 * 
 * Problem #: 2828
 * Problem link: https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
 * 
 * Attempt Date: 23/08/2023
 * 
 * @author: Rishabh Soni
 * 
 */
public class ArconymValidator {

    public static boolean isAcronym(List<String> words, String s) {

        int i = 0;
        for (String word : words) {

            if (i == s.length()) {
                return false;
            }

            char c = s.charAt(i);
            if (word.charAt(0) != c) {
                return false;
            }

            i++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList("never", "gonna", "give", "up", "on", "you");

        System.out.println(isAcronym(words, "ngguoq"));

    }

}
