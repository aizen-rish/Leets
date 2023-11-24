package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1630
 * 
 * Problem link: https://leetcode.com/problems/arithmetic-subarrays/
 * 
 * Date Attempted: 23/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ArithmeticSubArrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> ans = new ArrayList<>();

        int m = l.length;
        for (int i = 0; i < m; i++) {

            int lR = l[i];
            int rR = r[i] + 1;

            if (rR - lR == 2) {
                ans.add(true);
                continue;
            }

            if (rR - lR < 2) {
                ans.add(false);
                continue;
            }

            ans.add(checkInternal(Arrays.copyOfRange(nums, lR, rR)));
        }

        return ans;
    }

    private boolean checkInternal(int[] nums) {

        Arrays.sort(nums);

        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

}
