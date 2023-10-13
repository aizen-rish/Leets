package rish.leets.contests.biweekly;

/*
 *        BiWeekly Contest 110
 * 
 * Problem #: 2806
 * Contest link: https://leetcode.com/contest/biweekly-contest-110/
 * Problem link: https://leetcode.com/problems/account-balance-after-rounded-purchase
 * 
 * Attempt Date: 05/08/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class RoundedPurchase {

    public int accountBalanceAfterPurchase(int a) {

        int rem = a % 10;

        if (rem == 0) {
            return 100 - a;
        }

        if (rem < 5) {
            return 100 - a + rem;
        }

        return 100 - a - 10 + rem;
    }

}
