package rish.leets.grind.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * Grind 75 : Week 5
 * 
 * Problem #: LC78
 * Problem link : https://leetcode.com/problems/subsets/
 * 
 * Date Attempted: 13/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> subAnswer, int[] nums, int start) {

        // Solve using backtracking
        ans.add(new ArrayList<>(subAnswer));

        for (int i = start; i < nums.length; i++) {
            subAnswer.add(nums[i]);
            backtrack(ans, subAnswer, nums, i + 1);
            subAnswer.remove(subAnswer.size() - 1);
        }
    }

}
