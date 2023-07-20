package rish.leets.contests.weekly;

import java.util.List;

/*
 *            Weekly Contest 354
 * 
 * Problem #: 2780
 * Problem link: https://leetcode.com/problems/minimum-index-of-a-valid-split/
 * Contest link: https://leetcode.com/contest/weekly-contest-354/
 * 
 * Date Attempted: 16/07/2023
 * 
 * @author Rishabh Soni
 * 
 */
public class MinimumValidSplit {

    public int minimumIndex(List<Integer> nums) {

        int size = nums.size();
        int cand = -1;
        int votes = 0;

        // Find dominant element
        for (int x : nums) {
            if (votes == 0) {
                cand = x;
            }
            votes += (cand == x) ? 1 : -1;
        }

        int freq = 0;
        int dom = cand;

        // Find frequency of dominant element
        for (int x : nums) {
            if (x == dom) {
                freq++;
            }
        }

        votes = 0;
        for (int i = 0; i < size; i++) {

            if (dom == nums.get(i)) {
                votes++;
            }

            // check for index i as pivot
            int prePivot = votes * 2;
            int postPivot = freq * 2 - prePivot;
            if (prePivot > i + 1 && postPivot > (size - i - 1)) {
                return i;
            }
        }

        return -1;
    }

}
