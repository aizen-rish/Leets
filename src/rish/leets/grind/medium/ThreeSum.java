package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: 15
 * Problem link : https://leetcode.com/problems/3sum/
 * 
 * Date Attempted: 18/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length == 0) {
            return Collections.emptyList();
        }

        Set<List<Integer>> answer = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            int target = -nums[i];

            int front = i + 1;
            int back = nums.length - 1;

            while (front < back && front < nums.length) {

                int val = nums[front] + nums[back];

                if (val == target) {
                    answer.add(Arrays.asList(nums[i], nums[front], nums[back]));
                }

                front += val > target ? 0 : 1;
                back -= val < target ? 0 : 1;
            }
        }

        return new ArrayList<>(answer);
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(arr));
    }

}
