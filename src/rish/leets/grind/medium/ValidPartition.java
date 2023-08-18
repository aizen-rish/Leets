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

    public static void main(String[] args) {

        int[] arr = { 4, 4, 4, 5, 6 };

        System.out.println(validPartition(arr));
    }

}
