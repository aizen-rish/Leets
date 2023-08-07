package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: 50
 * Problem link: https://leetcode.com/problems/powx-n/
 * 
 * Date Attempted: 24/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class PowX {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (x == 0) {
            return 0;
        }

        if (n == 1 || x == 1) {
            return x;
        }

        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }

        if (n < 0) {
            return 1 / x * myPow(x, -(n + 1));
        }

        double ans = 1;
        for (int i = n; i > 0; i = i / 2) {

            if (i % 2 != 0) {
                ans = ans * x;
                i--;
            }

            x = x * x;
        }

        return ans;
    }

}
