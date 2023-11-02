package rish.leets.grind.easy;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1356
 * Problem link: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 * 
 * Date Attempted: 30/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SortIntegersBySetBits {

    public int[] sortByBits(int[] arr) {

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> {
            int bitDiff = Integer.compare(bitCount(a), bitCount(b));
            return bitDiff == 0 ? Integer.compare(a, b) : bitDiff;
        });

        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

    int bitCount(int n) {
        int ans = 0;
        while (n > 0) {
            n &= (n - 1);
            ans++;
        }
        return ans;
    }

}
