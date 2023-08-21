package rish.leets.grind.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Daily Challenge!
 * 
 * Problem #: LC2369
 * Problem link: https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
 * 
 * Date Attempted: 13/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ValidPartition {

    static Map<Integer, Boolean> dp = new HashMap<>();

    /*
     * Recursive solution: Top-down approach
     */
    public static boolean validPartition(int[] nums) {
        return validPartitionInternal(nums, nums.length - 1);
    }

    private static boolean validPartitionInternal(int[] nums, int index) {

        System.out.println(" Here for index " + index);

        if (index < 0) {
            return true;
        }

        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        boolean ans = false;

        if (index > 0 && nums[index] == nums[index - 1]) {
            ans |= validPartitionInternal(nums, index - 2);
        }

        if (index > 1) {

            int a = nums[index];
            int b = nums[index - 1];
            int c = nums[index - 2];

            if (a == b && b == c) {
                ans |= validPartitionInternal(nums, index - 3);
            }
            if (a == b + 1 && b == c + 1) {
                ans |= validPartitionInternal(nums, index - 3);
            }
        }

        dp.put(index, ans);

        return ans;
    }

    /*
     * Iterative solution: Bottoms up appproach
     * 
     */
    public static boolean validPartition2(int[] nums) {

        int len = nums.length;
        boolean[] dp2 = new boolean[len + 1];

        dp2[0] = true;
        dp2[1] = false;

        for (int i = 1; i < len; i++) {

            boolean ans = false;

            if (i > 0 && nums[i] == nums[i - 1]) {
                ans |= dp2[i - 1];
            }

            if (i > 1) {

                int a = nums[i];
                int b = nums[i - 1];
                int c = nums[i - 2];

                if (a == b && b == c) {
                    ans |= dp2[i - 2];
                }
                if (c == b - 1 && b == a - 1) {
                    ans |= dp2[i - 2];
                }
            }

            dp2[i + 1] = ans;
        }

        return dp2[len];
    }

    public static void main(String[] args) {

        int[] arr = { 4, 4, 4, 5, 6 };

        System.out.println(validPartition2(arr));
    }

}
