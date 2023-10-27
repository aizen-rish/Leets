package rish.leets.contests.biweekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 *              Biweekly Contest 108
 * 
 * Problem #: 2766
 * Problem link: https://leetcode.com/problems/relocate-marbles/
 * Contest link: https://leetcode.com/contest/biweekly-contest-108/
 * 
 * Attempt Date: 08/07/2023
 * 
 * @author: Rishabh Soni
 * 
 */
public class RelocateMarbles {

    public static List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {

        Set<Integer> positionSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 0; i < moveTo.length; i++) {

            int x = moveFrom[i];
            int y = moveTo[i];

            positionSet.remove(x);
            positionSet.add(y);
        }

        List<Integer> answer = new ArrayList<>(positionSet);
        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = { 4, 6, 6, 9, 18 };
        int[] m1 = { 18, 6, 17, 4, 9, 19, 2 };
        int[] m2 = { 23, 17, 20, 19, 11, 2, 20 };

        System.out.println(relocateMarbles(nums, m1, m2));
    }

}
