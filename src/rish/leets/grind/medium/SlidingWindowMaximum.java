package rish.leets.grind.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Daily Challenge!
 * 
 * Problem #: LC239
 * Problem link: https://leetcode.com/problems/sliding-window-maximum/
 * 
 * Date Attempted: 16/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int ansIndex = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {

            int j = nums[i];

            while (!dq.isEmpty() && j > nums[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.add(i);
        }

        ans[ansIndex++] = nums[dq.peekFirst()];

        for (int i = k; i < len; i++) {

            if (dq.peekFirst() == i - k) {
                dq.removeFirst();
            }

            int j = nums[i];

            while (!dq.isEmpty() && j > nums[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.add(i);
            ans[ansIndex++] = nums[dq.peekFirst()];
        }

        return ans;
    }

}
