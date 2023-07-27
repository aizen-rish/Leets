package rish.leets.contests.biweekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 *        BiWeekly Contest 109
 * 
 * Problem #: 2785
 * Contest link: https://leetcode.com/contest/biweekly-contest-109/
 * Problem link: https://leetcode.com/problems/sort-vowels-in-a-string/
 * 
 * Attempt Date: 22/07/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class SortVowels {

    public static String sortVowels(String s) {

        final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        List<Character> sortedVowels = new ArrayList<>();
        List<Integer> vowelsIndex = new ArrayList<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (VOWELS.contains(c)) {
                sortedVowels.add(c);
                vowelsIndex.add(i);
            }
        }

        if (sortedVowels.isEmpty()) {
            return s;
        }

        Collections.sort(sortedVowels);

        StringBuilder ans = new StringBuilder(s);
        Iterator<Character> it = sortedVowels.iterator();

        for (int j : vowelsIndex) {
            ans.setCharAt(j, it.next());
            it.remove();
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
    }

}
