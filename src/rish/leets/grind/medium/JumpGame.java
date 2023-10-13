package rish.leets.grind.medium;

/*
 * Practice for Daily Challenge!
 * 
 * Problem #: LC55
 * Problem link: https://leetcode.com/problems/jump-game/
 * 
 * Date Attempted: 31/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

}
