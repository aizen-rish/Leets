package rish.leets.grind.easy;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: LC706
 * Problem link: https://leetcode.com/problems/design-hashmap/
 * 
 * Date Attempted: 04/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CustomHashMap {

    private int[] map;

    public CustomHashMap() {
        this.map = new int[10000001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        put(key, -1);
    }

}
