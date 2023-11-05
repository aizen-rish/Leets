package rish.leets.grind.medium;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1535
 * 
 * Problem link: https://leetcode.com/problems/find-the-winner-of-an-array-game/
 * 
 * Date Attempted: 05/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ArrayGameWinner {

    public static int getWinner(int[] arr, int k) {

        int cand = Math.max(arr[0], arr[1]);
        int wins = 1;

        for (int i = 2; i < arr.length; i++) {

            if (wins == k) {
                return cand;
            }

            if (cand > arr[i]) {
                wins++;
            } else {
                cand = arr[i];
                wins = 1;
            }

        }

        return cand;
    }

}
