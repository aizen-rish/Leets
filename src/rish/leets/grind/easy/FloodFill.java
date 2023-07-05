package rish.leets.grind.easy;

import java.util.Arrays;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 733
 * Problem link : https://leetcode.com/problems/flood-fill/
 * 
 * @author Rishabh Soni
 */
public class FloodFill {

  public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

    int m = image.length;
    int n = image[0].length;

    int existingColor = image[sr][sc];
    if (existingColor == color) {
      return image;
    }

    return floodFillInternal(image, m, n, sr, sc, color, existingColor);
  }

  public static int[][] floodFillInternal(int[][] image, int m, int n, int sr, int sc, int color, int existingColor) {

    if (sr >= m || sr < 0 || sc < 0 || sc >= n) {
      return image;
    }

    /*
     * Surrounding neighbors are: 1. sr-1,sc 2. sr, sc-1 3. sr+1, sc 4. sr, sc+1
     */

    if (image[sr][sc] != existingColor) {
      return image;
    }

    image[sr][sc] = color;

    if (sr - 1 >= 0) {
      image = floodFillInternal(image, m, n, sr - 1, sc, color, existingColor);
    }

    if (sr + 1 < m) {
      image = floodFillInternal(image, m, n, sr + 1, sc, color, existingColor);
    }

    if (sc - 1 >= 0) {
      image = floodFillInternal(image, m, n, sr, sc - 1, color, existingColor);
    }

    if (sc + 1 < n) {
      image = floodFillInternal(image, m, n, sr, sc + 1, color, existingColor);
    }

    return image;
  }

  public static void main(String[] args) {

    int[][] arr = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
    int[][] image = floodFill(arr, 1, 1, 2);

    System.out.println(Arrays.deepToString(image));
  }

}
