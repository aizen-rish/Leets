package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Daily Challenge!
 * 
 * Problem #: 77
 * Problem link: https://leetcode.com/problems/combinations/
 * 
 * Date Attempted: 01/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class KCombinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> subAnswer, int start, int n, int k) {

        if (k == 0) {
            ans.add(new ArrayList<>(subAnswer));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            subAnswer.add(i);
            backtrack(ans, subAnswer, i + 1, n, k - 1);
            subAnswer.remove(subAnswer.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(combine(5, 2));

    }

}
