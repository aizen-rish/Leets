package rish.leets.contests.biweekly;

import java.util.List;

/*
 *        BiWeekly Contest 111
 * 
 * Problem #: 2824
 * Contest link: https://leetcode.com/contest/biweekly-contest-111/
 * Problem link: https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target
 * 
 * Attempt Date: 19/08/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class CountPairsWithSumTarget {

    public int countPairs(List<Integer> nums, int target) {

        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            int a = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                if (a + nums.get(j) < target) {
                    count++;
                }
            }
        }

        return count;
    }

}
