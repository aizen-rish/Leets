package rish.leets.grind.medium;

/**
 * Daily Challenge!
 * 
 * Problem #: LC2433
 * 
 * Problem link:
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
 * 
 * Date Attempted: 31/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class OriginalPrefixXor {

    public int[] findArray(int[] pref) {

        int[] ans = new int[pref.length];

        ans[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            ans[i] = pref[i] ^ pref[i - 1];
        }

        return ans;
    }

}
