package rish.leets.grind.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1512
 * Problem link: https://leetcode.com/problems/number-of-good-pairs/
 * 
 * Date Attempted: 03/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class GoodPairCount {

    public int numIdenticalPairs(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int freq = freqMap.getOrDefault(nums[i], 0);
            ans += freq;
            freqMap.put(nums[i], freq + 1);
        }

        return ans;
    }

}
