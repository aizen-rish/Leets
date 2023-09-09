package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Practice for Daily Challenge!
 * 
 * Problem #: LC45
 * Problem link: https://leetcode.com/problems/jump-game-ii/
 * 
 * Date Attempted: 31/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class JumpGame2 {

    public static int jump(int[] nums) {

        int len = nums.length;

        int[] minJump = new int[len];
        Arrays.fill(minJump, Integer.MAX_VALUE);

        minJump[0] = 0;

        for (int i = 0; i < len; i++) {
            int x = nums[i];
            if (i + x >= len - 1) {
                minJump[len - 1] = Math.min(minJump[len - 1], minJump[i] + 1);
                break;
            }
            for (int j = 1; j <= x; j++) {
                minJump[i + j] = Math.min(minJump[i] + 1, minJump[i + j]);
            }
        }

        return minJump[len - 1];
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 0, 1, 4 };

        System.out.println(jump(arr));

    }

}
