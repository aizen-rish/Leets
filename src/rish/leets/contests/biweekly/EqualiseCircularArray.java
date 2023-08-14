package rish.leets.contests.biweekly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *        BiWeekly Contest 110
 * 
 * Problem #: 2808
 * Contest link: https://leetcode.com/contest/biweekly-contest-110/
 * Problem link: https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array
 * 
 * Attempt Date: 09/08/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class EqualiseCircularArray {

    public static int minimumSeconds(List<Integer> nums) {

        Map<Integer, Integer> lastSeen = new HashMap<>();
        Map<Integer, Integer> middleEle = new HashMap<>();

        int size = nums.size();

        for (int i = 0; i < size; i++) {

            int j = nums.get(i);

            if (lastSeen.containsKey(j)) {
                int diff = i - lastSeen.get(j) - 1;
                middleEle.compute(j, (k, v) -> v == null ? diff : Math.max(v, diff));
            }

            lastSeen.put(j, i);
        }

        System.out.println(lastSeen);
        System.out.println(middleEle);

        for (int i = 0; i < size; i++) {

            int j = nums.get(i);

            int diff = (i - lastSeen.get(j) - 1 + size) % size;
            middleEle.compute(j, (k, v) -> v == null ? diff : Math.max(v, diff));

            lastSeen.put(j, i);
        }

        System.out.println(lastSeen);
        System.out.println(middleEle);

        return middleEle.values().stream().min(Comparator.naturalOrder()).map(x -> (x + 1) / 2).get();
    }

    public static void main(String[] args) {

        System.out.println(minimumSeconds(Arrays.asList(8, 13, 3, 3)));

    }

}
