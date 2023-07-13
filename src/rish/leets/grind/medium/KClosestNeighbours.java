package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: 973
 * Problem link : https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * Date Attempted: 13/07/2022
 * 
 * @author Rishabh Soni
 *
 */
public class KClosestNeighbours {

    private static double distance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }

    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> {
            double diff = distance(a) - distance(b);
            if (diff == 0) {
                return 0;
            } else {
                return diff > 0 ? 1 : -1;
            }
        });
        return Arrays.copyOfRange(points, 0, k);
    }

    public static void main(String[] args) {

        int arr[][] = { { 0, 1 }, { 1, 0 }, { -2, 4 } };

        int[][] ans = kClosest(arr, 2);
        System.out.println(Arrays.deepToString(ans));
    }

}
