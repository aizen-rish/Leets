package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 39
 * Problem link : https://leetcode.com/problems/combination-sum/
 * 
 * Date Attempted: 31/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), candidates, target, 0);

        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> subAnswer, int[] candidates, int target,
            int index) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(subAnswer));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int j = candidates[i];
            subAnswer.add(j);
            backtrack(ans, subAnswer, candidates, target - j, i);
            subAnswer.remove(subAnswer.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5 };

        System.out.println(combinationSum(arr, 8));

    }

}
