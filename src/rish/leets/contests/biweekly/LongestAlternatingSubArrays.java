package rish.leets.contests.biweekly;

import java.util.ArrayList;
import java.util.List;

/*
 *              Biweekly Contest 108
 * 
 * Problem #: 2765
 * Problem link: https://leetcode.com/problems/longest-alternating-subarray
 * Contest link: https://leetcode.com/contest/biweekly-contest-108/
 * 
 * Attempt Date: 09/07/2023
 * 
 * @author: Rishabh Soni
 * 
 */
public class LongestAlternatingSubArrays {

    public static int alternatingSubarray(int[] nums) {

        int maxCount = -1;

        for (int i = 0; i < nums.length; i++) {

            List<Integer> subArray = new ArrayList<>();
            subArray.add(nums[i]);

            int m = subArray.size();
            int subMax = -1;

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] - nums[j - 1] != (int) Math.pow(-1, m + 1)) {
                    break;
                }

                m++;
                subArray.add(nums[j]);
                subMax = Math.max(subMax, m);
            }

            maxCount = Math.max(maxCount, subMax);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = { 21, 9, 5 };
        alternatingSubarray(arr);
    }

}
