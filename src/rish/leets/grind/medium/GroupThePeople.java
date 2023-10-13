package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Daily Challenge!
 * 
 * Problem #: 1282
 * Problem link: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * 
 * Date Attempted: 11/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        int n = groupSizes.length;

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int j = groupSizes[i];
            map.computeIfAbsent(j, a -> new ArrayList<>()).add(i);

            List<Integer> subAnswer = map.get(j);
            if (subAnswer.size() == j) {
                ans.add(subAnswer);
                map.remove(j);
            }
        }

        return ans;
    }

}
