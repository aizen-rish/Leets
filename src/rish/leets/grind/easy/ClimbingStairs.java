package rish.leets.grind.easy;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 70
 * Problem link : https://leetcode.com/problems/climbing-stairs/
 * 
 * Date Attempted: 05/07/2023
 * 
 * @author Rishabh Soni
 * 
 */
public class ClimbingStairs {

    public static int climbStairs(int x) {

        int y = x / 2;

        /*
         * Approach: The number can be expressed in form all 1's. For every pair of
         * these 1's, we can replace with 2 and place anywhere (combination sum)
         */
        int sum = 1;
        for (int i = 1; i <= y; i++) {
            sum += comb(x - i, i);
        }

        return sum;
    }

    private static int comb(int n, int r) {

        if (r > n) {
            return 0;
        }

        if (r == 0 || n == r) {
            return 1;
        }

        if (r == 1) {
            return n;
        }

        long sum = 1;
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }

}
