package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: LC74
 * Problem link: https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * Date Attempted: 07/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        // find row using binary search
        int left = 0;
        int right = m - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            int ele = matrix[mid][0];

            if (ele > target) {
                right = mid - 1;
            } else if (ele < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        // find col using binary search
        int row = left == 0 ? left : left - 1;
        left = 0;
        right = n - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            int ele = matrix[row][mid];

            if (ele > target) {
                right = mid - 1;
            } else if (ele < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
