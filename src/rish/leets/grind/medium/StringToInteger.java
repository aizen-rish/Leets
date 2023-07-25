package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 8
 * Problem link : https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * Date Attempted: 06/07/2023
 * 
 * @author Rishabh Soni
 * 
 */
public class StringToInteger {

    public static int myAtoi(String s) {

        String t = s.trim();

        boolean isPositive = true;
        boolean hasSignCharacter = false;
        boolean hasParsedDigit = false;
        List<Integer> digits = new ArrayList<>();

        for (char c : t.toCharArray()) {

            if (c == '+' || c == '-') {

                if (hasSignCharacter || hasParsedDigit) {
                    break;
                }

                hasSignCharacter = true;
                isPositive = (c == '+');
                continue;
            }

            if (!Character.isDigit(c)) {
                break;
            }

            hasParsedDigit = true;
            digits.add(Integer.parseInt(String.valueOf(c)));
        }

        // remove early zeros
        for (int i = 0; i < digits.size(); i++) {

            if (digits.get(i) > 0) {
                break;
            }

            digits.remove(i);
            i--;
        }

        if (digits.isEmpty()) {
            return 0;
        }

        if (digits.size() > 10) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        int i = digits.size() - 1;
        long answer = 0;

        for (int d : digits) {
            answer += (d * Math.pow(10, i));
            i--;
        }

        answer *= isPositive ? 1 : -1;

        if (answer > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (answer < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("    3434A"));
        System.out.println(myAtoi("    -3434A4545   "));
        System.out.println(myAtoi("43"));
        System.out.println(myAtoi("00000403"));
        System.out.println(myAtoi("000000"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("-4147483648"));
        System.out.println(myAtoi("4147483648"));
        System.out.println(myAtoi("-21474836483"));
        System.out.println(myAtoi("21474836486"));
        System.out.println(myAtoi("+-12"));
    }

}
