package rish.leets.grind.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Daily Challenge!
 * 
 * Problem #: LC119
 * 
 * Problem link: https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * Date Attempted: 16/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> prev = Arrays.asList(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(prev.get(j - 1) + prev.get(j));
            }
            temp.add(1);
            prev = temp;
        }

        return prev;
    }

}
