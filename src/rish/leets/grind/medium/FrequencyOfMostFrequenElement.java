package rish.leets.grind.medium;

import java.util.Arrays;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1359
 * 
 * Problem link:
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 * 
 * Date Attempted: 18/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class FrequencyOfMostFrequenElement {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int len = nums.length;
        long sum = 0;
        int ans = 1;
        int j = 0;

        for (int i = 0; i < len; i++) {

            int ele = nums[i];
            sum += ele;

            if ((i - j + 1) * ele - sum > k) {
                sum -= nums[j];
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }

    public int maxFrequency2(int[] nums, int k) {

        Arrays.sort(nums);

        int len = nums.length;
        int ans = 1;

        // calculate prefix sum to use in b-search
        long[] prefix = new long[len];
        prefix[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        // Using binary search
        for (int i = 0; i < len; i++) {
            int bisect = bsearch(i, k, nums, prefix);
            ans = Math.max(ans, i - bisect + 1);
        }

        return ans;
    }

    private int bsearch(int index, int k, int[] nums, long[] prefix) {

        int i = 0;
        int j = index;
        int ans = index;

        while (i <= j) {

            int mid = (i + j) / 2;
            long count = index - mid + 1;
            long expected = count * nums[index];
            long actual = prefix[index] - prefix[mid] + nums[mid];
            long diff = expected - actual;

            if (diff > k) {
                i = mid + 1;
            } else {
                j = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }

}
