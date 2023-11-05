package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rish.leets.grind.common.utils.TreeNode;

/**
 * Daily Challenge!
 * 
 * Problem #: LC894
 * 
 * Problem link: https://leetcode.com/problems/all-possible-full-binary-trees/
 * 
 * Date Attempted: 23/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class GenerateFullBinaryTrees {

    private Map<Integer, List<TreeNode>> dp = new HashMap<>();

    /*
     * Top-down approach : Recursive
     */
    public List<TreeNode> allPossibleFBT(int n) {

        if (n % 2 == 0) {
            return Collections.emptyList();
        }

        if (n == 1) {
            return Collections.singletonList(new TreeNode(0));
        }

        List<TreeNode> ans = new ArrayList<>();

        for (int i = 1; i < n; i = i + 2) {

            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(n - 1 - i);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode temp = new TreeNode(0, left, right);
                    ans.add(temp);
                }
            }
        }

        dp.put(n, ans);
        return ans;
    }

    /*
     * Bottom-up approach : Iterative
     */
    public List<TreeNode> allPossibleFBT2(int n) {

        if (n % 2 == 0) {
            return Collections.emptyList();
        }

        if (n == 1) {
            return Collections.singletonList(new TreeNode(0));
        }

        List<List<TreeNode>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }

        dp.set(1, Collections.singletonList(new TreeNode(0)));

        for (int m = 1; m <= n; m += 2) {

            for (int i = 1; i < m - 1; i = i + 2) {

                List<TreeNode> lefts = dp.get(i);
                List<TreeNode> rights = dp.get(m - 1 - i);

                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        dp.get(m).add(new TreeNode(0, left, right));
                    }
                }
            }
        }

        return dp.get(n);
    }

}
