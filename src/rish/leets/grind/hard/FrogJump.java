package rish.leets.grind.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
 * Daily Challenge!
 * 
 * Problem #: 403
 * Problem link: https://leetcode.com/problems/frog-jump/
 * 
 * Date Attempted: 27/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class FrogJump {

    public static boolean canCross(int[] stones) {

        if (stones.length == 2) {
            return stones[1] - stones[0] == 1;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        IntStream.range(0, stones.length).forEach(i -> indexMap.put(stones[i], i));

        int[][] dp = new int[2001][2001];

        return canCrossInternal(stones, 1, 1, dp, indexMap);
    }

    private static boolean canCrossInternal(int[] stones, int i, int k, int[][] dp, Map<Integer, Integer> indexMap) {

        if (i == stones.length - 1) {
            return true;
        }

        if (dp[i][k] != 0) {
            return dp[i][k] == 2;
        }

        boolean ans = false;

        int curr = stones[i];
        int[] possibleMoves = { k - 1, k, k + 1 };

        for (int move : possibleMoves) {
            if (move > 0 && indexMap.containsKey(move + curr)) {
                ans |= canCrossInternal(stones, indexMap.get(move + curr), move, dp, indexMap);
            }
        }

        dp[i][k] = ans ? 2 : 1;
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 2, 4, 5, 6, 8, 9, 11, 14, 17, 18, 19, 20, 22, 23, 24, 25, 27, 30 };
        System.out.println(canCross(arr));
    }

}
