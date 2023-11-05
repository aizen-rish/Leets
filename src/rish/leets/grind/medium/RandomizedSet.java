package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Practice Prep - 150
 * 
 * Problem #: LC380
 * 
 * Problem link: https://leetcode.com/problems/insert-delete-getrandom-o1/
 * 
 * Date Attempted: 05/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class RandomizedSet {

    private Random rand;
    private HashMap<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        this.rand = new Random();
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }

        int newIndex = list.size();

        map.put(val, newIndex);
        list.add(newIndex, val);
        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int oldIndex = map.get(val);
        if (oldIndex < list.size() - 1) {
            int ele = list.get(list.size() - 1);
            list.add(oldIndex, ele);
        }

        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();
        obj.insert(0);
        obj.remove(0);
        obj.insert(-1);
        obj.remove(0);
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }

}
