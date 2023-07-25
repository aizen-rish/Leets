package rish.leets.contests.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *        Weekly Contest 352
 * 
 * Problem #: 2761
 * Problem link: https://leetcode.com/problems/prime-pairs-with-target-sum/
 * 
 * Attempt Date: 04/07/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class PrimePairsSum {

    public static List<List<Integer>> findPrimePairs(int n) {

        if (n < 4) {
            return Collections.emptyList();
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 2; i <= n / 2; i++) {
            int j = n - i;
            if (isPrime(i) && isPrime(j)) {
                answer.add(Arrays.asList(i, j));
            }
        }

        return answer;
    }

    private static boolean isPrime(int i) {

        if (i == 2 || i == 3) {
            return true;
        }

        if (i % 2 == 0 || i % 3 == 0) {
            return false;
        }

        for (int j = 5; j * j <= i; j = j + 6) {
            if (i % j == 0 || i % (j + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(findPrimePairs(1000000));
    }

}
