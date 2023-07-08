package rish.leets.contests.weekly;

/*
 *            Weekly Contest 351
 * 
 * Problem #: 2749
 * Problem link: https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero/
 * Contest link: https://leetcode.com/contest/weekly-contest-351/
 * 
 * Date Attempted: 28/06/2023
 * 
 * @author Rishabh Soni
 * 
 */
public class MakeIntegerZero {

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    public int makeTheIntegerZero(int num1, int num2) {

        if (num2 > num1) {
            return -1;
        }

        for (int i = 0; i < 61; i++) {
            int sum = num1 - (i * num2);
            if (countSetBits(sum) <= i && i <= sum) {
                return i;
            }
        }

        return -1;
    }

}
