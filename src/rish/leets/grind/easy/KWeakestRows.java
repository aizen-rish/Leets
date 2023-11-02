package rish.leets.grind.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1337
 * Problem link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 * 
 * Date Attempted: 18/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class KWeakestRows {

    record Pair(int x, int y) {
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        int len = mat.length;

        List<Pair> lines = new ArrayList<>();
        IntStream.range(0, len).forEach(i -> lines.add(new Pair(i, binarySearch(mat[i]))));

        Collections.sort(lines, (a, b) -> Integer.compare(a.y(), b.y()));

        return lines.stream().mapToInt(i -> i.x()).limit(k).toArray();
    }

    private int binarySearch(int[] a) {

        int left = 0;
        int right = a.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (a[mid] == 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
