package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Daily Challenge!
 * 
 * Problem #: 17
 * Problem link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Date Attempted: 03/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class DigitLetterCombinations {

    private static Map<Character, List<Character>> DIGIT_MAP = new HashMap<>();

    static {
        DIGIT_MAP.put('2', Arrays.asList('a', 'b', 'c'));
        DIGIT_MAP.put('3', Arrays.asList('d', 'e', 'f'));
        DIGIT_MAP.put('4', Arrays.asList('g', 'h', 'i'));
        DIGIT_MAP.put('5', Arrays.asList('j', 'k', 'l'));
        DIGIT_MAP.put('6', Arrays.asList('m', 'n', 'o'));
        DIGIT_MAP.put('7', Arrays.asList('p', 'q', 'r', 's'));
        DIGIT_MAP.put('8', Arrays.asList('t', 'u', 'v'));
        DIGIT_MAP.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> ans = new ArrayList<>();

        for (char c : digits.toCharArray()) {

            List<Character> letters = DIGIT_MAP.get(c);

            if (ans.isEmpty()) {
                ans.addAll(letters.stream().map(String::valueOf).collect(Collectors.toList()));
                continue;
            }

            List<String> temp = new ArrayList<>();
            for (String s : ans) {
                letters.forEach(letter -> {
                    temp.add(s + letter);
                });
            }
            ans = temp;
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "234";
        System.out.println(letterCombinations(s));

    }

}
