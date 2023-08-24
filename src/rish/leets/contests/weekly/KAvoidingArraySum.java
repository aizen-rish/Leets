package rish.leets.contests.weekly;

import java.util.HashSet;
import java.util.Set;

/*
 *        Weekly Contest 359
 * 
 * Problem #: 2829
 * Problem link: https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/
 * 
 * Attempt Date: 23/08/2023
 * 
 * @author: Rishabh Soni
 * 
 */
public class KAvoidingArraySum {

    public static int minimumSum(int n, int k) {

        if (n == 1 || k == 1) {
            return n * (n + 1) / 2;
        }

        Set<Integer> forb = new HashSet<>();

        int count = 0;
        int sum = 0;

        for (int i = 1; i <= k / 2; i++) {

            sum += i;
            count++;
            forb.add(k - i);

            if (count == n) {
                return sum;
            }
        }

        if (k % 2 == 0) {
            forb.remove(k / 2);
        }

        sum = 0;
        count = 0;

        int i = 1;
        while (count < n) {
            if (!forb.contains(i)) {
                sum += i;
                count++;
            }
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(5, 4));
    }

}
