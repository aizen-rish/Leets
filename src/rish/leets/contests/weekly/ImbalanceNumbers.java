package rish.leets.contests.weekly;

import java.util.HashSet;
import java.util.Set;

/*
 *        Weekly Contest 352
 * 
 * Problem #: 2763
 * Problem link: https://leetcode.com/problems/sum-of-imbalance-numbers-of-all-subarrays/
 * 
 * Attempt Date: 07/07/2023
 * 
 * @author: Rishabh Soni
 * 
 */
public class ImbalanceNumbers {

    public static int sumImbalanceNumbers(int[] nums) {

        int answer = 0;

        for (int i = 0; i < nums.length; i++) {

            int segments = 0;
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < nums.length; j++) {

                int x = nums[j];

                if (!set.contains(x)) {

                    set.add(x);
                    segments++;

                    if (set.contains(x - 1)) {
                        segments--;
                    }
                    if (set.contains(x + 1)) {
                        segments--;
                    }
                }

                answer += segments - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2 };
        System.out.println(sumImbalanceNumbers(arr));
    }

}
