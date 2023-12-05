package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1980
 * 
 * Problem link: https://leetcode.com/problems/find-unique-binary-string/
 * 
 * Date Attempted: 16/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class FindUniqueBinaryStrings {

    /*
     * Using recursion to create all possible strings.
     */
    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;

        HashSet<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }

        List<String> allStrings = new ArrayList<>();
        binStringInternal(allStrings, "", 0, n);

        for (String ans : allStrings) {
            if (!set.contains(ans)) {
                return ans;
            }
        }

        return "";
    }

    private void binStringInternal(List<String> ans, String temp, int i, int n) {

        if (i == n) {
            ans.add(temp);
            return;
        }

        binStringInternal(ans, temp + "1", i + 1, n);
        binStringInternal(ans, temp + "0", i + 1, n);
    }

    /*
     * Optimized. Generates random numbers in range to guess answer.
     */
    public String findDifferentBinaryString2(String[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        int n = nums.length;
        int limit = (int) Math.pow(2, n);

        int ans = 0;
        Random rand = new Random();
        do {
            ans = rand.nextInt(limit);
        } while (set.contains(ans));

        String s = Integer.toBinaryString(ans);
        if (s.length() < n) {
            s = "0".repeat(n - s.length()) + s;
        }

        return s;
    }

}
