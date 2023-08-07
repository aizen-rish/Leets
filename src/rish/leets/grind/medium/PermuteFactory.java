package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 46
 * Problem link : https://leetcode.com/problems/permutations/
 * 
 * Date Attempted: 01/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class PermuteFactory {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);

        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> subAnswer, int[] nums) {

        if (subAnswer.size() == nums.length) {
            ans.add(new ArrayList<>(subAnswer));
            return;
        }

        for (int x : nums) {

            if (subAnswer.contains(x)) {
                continue;
            }

            subAnswer.add(x);
            System.out.println(subAnswer);
            backtrack(ans, subAnswer, nums);
            subAnswer.remove(subAnswer.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5 };

        System.out.println(permute(arr));

    }

}
