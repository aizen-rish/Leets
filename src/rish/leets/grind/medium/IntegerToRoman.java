package rish.leets.grind.medium;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Practice Prep - 150
 * 
 * Problem #: LC12
 * 
 * Problem link: https://leetcode.com/problems/integer-to-roman/
 * 
 * Date Attempted: 03/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class IntegerToRoman {

    private static final SortedMap<Integer, String> VALUE_MAP = new TreeMap<>(Collections.reverseOrder());

    static {
        VALUE_MAP.put(1000, "M");
        VALUE_MAP.put(900, "CM");
        VALUE_MAP.put(500, "D");
        VALUE_MAP.put(400, "CD");
        VALUE_MAP.put(100, "C");
        VALUE_MAP.put(90, "XC");
        VALUE_MAP.put(50, "L");
        VALUE_MAP.put(40, "XL");
        VALUE_MAP.put(10, "X");
        VALUE_MAP.put(9, "IX");
        VALUE_MAP.put(5, "V");
        VALUE_MAP.put(4, "IV");
        VALUE_MAP.put(1, "I");
    }

    public static String intToRoman(int num) {

        int rem = num;
        StringBuilder sb = new StringBuilder();

        for (int x : VALUE_MAP.keySet()) {

            int quo = rem / x;
            rem = rem % x;

            if (quo > 0) {

                String letter = VALUE_MAP.get(x);
                if (quo > 1) {
                    sb.append(String.join("", Collections.nCopies(quo, letter)));
                } else {
                    sb.append(letter);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(4));
    }

}
