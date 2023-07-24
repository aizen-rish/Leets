package rish.leets.grind.medium;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: 238
 * Problem link : https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Date Attempted: 02/09/2022
 * 
 * @author Rishabh Soni
 *
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] out = new int[size];

        out[0] = 1;
        for (int i = 1; i < size; i++) {
            out[i] = out[i - 1] * nums[i - 1];
        }

        int var = nums[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            out[i] *= var;
            var *= nums[i];
        }

        return out;
    }

}
