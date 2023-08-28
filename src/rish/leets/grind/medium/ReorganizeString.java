package rish.leets.grind.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Daily Challenge!
 * 
 * Problem #: LC767
 * Problem link: https://leetcode.com/problems/reorganize-string/
 * 
 * Date Attempted: 23/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ReorganizeString {

    public static String reorganizeString(String s) {

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.merge(c, 1, (v1, v2) -> v1 + 1);
        }

        Comparator<Character> freqComparator = (a, b) -> freq.get(b) - freq.get(a);
        PriorityQueue<Character> queue = new PriorityQueue<>(freqComparator);
        queue.addAll(freq.keySet());

        int maxFreq = freq.get(queue.peek());
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        String ans = "";

        while (queue.size() > 1) {

            char a = queue.poll();
            char b = queue.poll();

            freq.compute(a, (k, v) -> v - 1);
            freq.compute(b, (k, v) -> v - 1);

            if (freq.get(a) > 0) {
                queue.add(a);
            }

            if (freq.get(b) > 0) {
                queue.add(b);
            }

            ans += a;
            ans += b;
        }

        if (!queue.isEmpty()) {
            char a = queue.poll();
            if (freq.get(a) > 1) {
                return "";
            }
            ans += a;
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(reorganizeString("vvvlo"));

    }

}
