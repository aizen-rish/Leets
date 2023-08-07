package rish.leets.grind.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Daily Challenge!
 * 
 * Problem #: 808
 * Problem link: https://leetcode.com/problems/soup-servings/
 * 
 * Date Attempted: 29/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SoupServings {

    public static double soupServings(int n) {

        if (n > 4800) {
            return 1.0;
        }

        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
        return soupServings(n, n, 1.0, dp);
    }

    public static double soupServings(int a, int b, double chances, Map<Integer, Map<Integer, Double>> dp) {

        if (a <= 0 && b <= 0) {
            return 0.5 * chances;
        }

        if (a <= 0) {
            return 1.0 * chances;
        }

        if (b <= 0) {
            return 0.0;
        }

        if (dp.containsKey(a) && dp.get(a).containsKey(b)) {
            return dp.get(a).get(b);
        }

        double x = soupServings(a - 100, b, chances * 0.25, dp);
        double y = soupServings(a - 75, b - 25, chances * 0.25, dp);
        double z = soupServings(a - 50, b - 50, chances * 0.25, dp);
        double v = soupServings(a - 25, b - 75, chances * 0.25, dp);

        dp.computeIfAbsent(a, key -> new HashMap<>()).put(b, x + y + z + v);

        return dp.get(a).get(b);
    }

    public static void main(String[] args) {

        System.out.println(soupServings(1500));

    }

}
