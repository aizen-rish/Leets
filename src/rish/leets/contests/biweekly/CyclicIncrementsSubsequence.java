package rish.leets.contests.biweekly;

import java.util.ArrayList;
import java.util.List;

/*
 *        BiWeekly Contest 111
 * 
 * Problem #: 2825
 * Contest link: https://leetcode.com/contest/biweekly-contest-111/
 * Problem link: https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments
 * 
 * Attempt Date: 19/08/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class CyclicIncrementsSubsequence {

    public static boolean canMakeSubsequence(String str1, String str2) {

        List<Integer> i2 = new ArrayList<>();

        for (char c : str2.toCharArray()) {
            i2.add(c - 'a');
        }

        System.out.println(i2);

        int i = 0;

        for (int j = 0; j < str1.length(); j++) {

            int x = str1.charAt(j) - 'a';
            int y = i2.get(i);

            if (x == y || (x + 1) % 26 == y) {
                i++;
            }

            if (i == str2.length()) {
                break;
            }
        }

        return i == str2.length();
    }

    public static void main(String[] args) {

        System.out.println(canMakeSubsequence("dm", "e"));
    }

}
