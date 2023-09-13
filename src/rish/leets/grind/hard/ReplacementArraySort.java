package rish.leets.grind.hard;

/*
 * Daily Challenge!
 * 
 * Problem #: LC2366
 * Problem link: https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
 * 
 * Date Attempted: 30/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ReplacementArraySort {

    public long minimumReplacement(int[] nums) {

        long ans = 0;
        int len = nums.length;

        /*
         * In one operation you can replace any element of the array with any two
         * elements that sum to it.
         */

        for (int i = len - 2; i >= 0; i--) {

            int curr = nums[i];
            int prev = nums[i + 1];
            if (prev >= curr) {
                continue;
            }

            int scale = curr / prev;
            if (curr % prev != 0) {
                scale++;
            }
            ans += scale - 1;
            nums[i] = curr / scale;
        }

        return ans;
    }

}
