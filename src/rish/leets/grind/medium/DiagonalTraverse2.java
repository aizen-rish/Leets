package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /*
     * Alternative approach : Using BFS
     */

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[] findDiagonalOrder2(List<List<Integer>> nums) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            Pair node = q.remove();
            int i = node.i;
            int j = node.j;

            List<Integer> curr = nums.get(i);
            ans.add(curr.get(j));

            q.addAll(getNext(i, j, nums.size(), curr.size()));
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private List<Pair> getNext(int i, int j, int m, int n) {

        List<Pair> next = new ArrayList<>();

        if (i + 1 < m && j == 0) {
            next.add(new Pair(i + 1, j));
        }

        if (j + 1 < n) {
            next.add(new Pair(i, j + 1));
        }

        return next;
    }

}
