package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: LC287
 * Problem link: https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Date Attempted: 19/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        /*
         * Use two pointer approach similar to finding cycle in linked list
         */

        do {
            System.out.println(slow + " : " + fast);
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
