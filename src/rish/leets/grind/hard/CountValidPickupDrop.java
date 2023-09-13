package rish.leets.grind.hard;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1359
 * Problem link: https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
 * 
 * Date Attempted: 10/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CountValidPickupDrop {

    private static final int MOD = 1000000007;

    public int countOrders(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            int subAns = ((2 * i) - 1) * i;
            ans = (ans * subAns) % MOD;
        }
        return (int) ans;
    }

}
