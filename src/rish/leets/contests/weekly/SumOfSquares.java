package rish.leets.contests.weekly;

/*
 *            Weekly Contest 354
 * 
 * Problem #: 2778
 * Problem link: leetcode.com/problems/sum-of-squares-of-special-elements
 * Contest link: https://leetcode.com/contest/weekly-contest-354/
 * 
 * Date Attempted: 16/07/2023
 * 
 * @author Rishabh Soni
 * 
 */
public class SumOfSquares {

    public int sumOfSquares(int[] nums) {

        // 1 always divides N
        int ans = nums[0] * nums[0];

        int n = nums.length;
        if (n == 1) {
            return ans;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                ans += nums[i - 1] * nums[i - 1];
                if (i != n / i) {
                    ans += Math.pow(nums[n / i - 1], 2);
                }
            }
        }

        // N always divides N
        ans += nums[n - 1] * nums[n - 1];

        return ans;
    }

}
