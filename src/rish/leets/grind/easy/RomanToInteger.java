package rish.leets.grind.easy;

/**
 * Practice Prep - 150
 * 
 * Problem #: LC13
 * 
 * Problem link: https://leetcode.com/problems/roman-to-integer/
 * 
 * Date Attempted: 13/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class RomanToInteger {

    enum ROMAN {
        I, V, X, L, C, D, M;
    }

    public static int romanToInt(String s) {

        int ans = 0;
        ROMAN prev = null;

        for (int i = 0; i < s.length(); i++) {

            String curr = s.substring(i, i + 1);

            ROMAN current = ROMAN.valueOf(curr);
            ans += checkSub(prev, current);

            prev = current;
        }

        return ans;
    }

    private static int checkSub(ROMAN previous, ROMAN current) {

        if (previous == null) {
            return getVal(current);
        }

        if (previous == ROMAN.I) {
            if (current == ROMAN.V || current == ROMAN.X) {
                return getVal(current) - 2;
            }
        }

        if (previous == ROMAN.X) {
            if (current == ROMAN.L || current == ROMAN.C) {
                return getVal(current) - 20;
            }
        }

        if (previous == ROMAN.C) {
            if (current == ROMAN.D || current == ROMAN.M) {
                return getVal(current) - 200;
            }
        }

        return getVal(current);
    }

    private static int getVal(ROMAN numeral) {

        switch (numeral) {

        case I:
            return 1;
        case V:
            return 5;
        case X:
            return 10;
        case L:
            return 50;
        case C:
            return 100;
        case D:
            return 500;
        case M:
            return 1000;

        }

        throw new IllegalArgumentException("Unknown numeral found : " + numeral);
    }

    public static void main(String[] args) {

        String num = "MCMXCIV";
        System.out.println(romanToInt(num));

    }

}
