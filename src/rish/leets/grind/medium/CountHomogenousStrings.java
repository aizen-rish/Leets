package rish.leets.grind.medium;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1759
 * 
 * Problem link:
 * https://leetcode.com/problems/count-number-of-homogenous-substrings/
 * 
 * Date Attempted: 09/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CountHomogenousStrings {

    private static final int MOD = 1000000007;

    public int countHomogenous(String s) {

        int len = s.length();

        int ans = 0;
        char prev = ' ';
        int subAns = 1;

        for (int i = 0; i < len; i++) {

            if (s.charAt(i) != prev) {
                subAns = 1;
                prev = s.charAt(i);
            }

            /*
             * Using n(n+1)/2 fails for big strings where n > 2^31. Just keep adding 1...n
             * iteratively instead.
             */
            ans = (ans + subAns) % MOD;
            subAns++;
        }

        return ans;
    }

}
