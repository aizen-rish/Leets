package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1424
 * 
 * Problem link: https://leetcode.com/problems/diagonal-traverse-ii/
 * 
 * Date Attempted: 22/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class DiagonalTraverse2 {

    class Tuple {
        int row;
        int col;
        int val;

        public Tuple(int a, int b, int c) {
            this.row = a;
            this.col = b;
            this.val = c;
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        List<Tuple> ans = new ArrayList<>();

        int len = nums.size();
        for (int i = 0; i < len; i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                ans.add(new Tuple(i, j, list.get(j)));
            }
        }

        Collections.sort(ans, (a, b) -> {
            int diff = (a.row - b.row) + (a.col - b.col);
            return diff == 0 ? Integer.compare(b.row, a.row) : diff;
        });

        return ans.stream().mapToInt(i -> i.val).toArray();
    }

}
