package rish.leets.grind.medium;

import java.util.Arrays;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1887
 * 
 * Problem link:
 * https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 * 
 * Date Attempted: 19/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class OperationsToEqualArray {

    public int reductionOperations(int[] nums) {

        Arrays.sort(nums);

        int ans = 0;
        int len = nums.length;

        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                ans += len - i;
            }
        }

        return ans;
    }

}
