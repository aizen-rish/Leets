package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 981
 * Problem link : https://leetcode.com/problems/time-based-key-value-store/
 * 
 * Date Attempted: 04/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class TimeBasedKeyValueStore {

    private Map<String, List<Integer>> timeMap;
    private Map<Integer, String> valueMap;

    public TimeBasedKeyValueStore() {
        timeMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, a -> new ArrayList<>()).add(timestamp);
        valueMap.put(timestamp, value);
    }

    public void getAndPrint(String key, int timestamp) {
        System.out.println(get(key, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Integer> times = timeMap.get(key);
        int timePrev = binarySearch(times, timestamp);

        if (timePrev == 0) {
            return "";
        }

        return valueMap.getOrDefault(timePrev, "");
    }

    private int binarySearch(List<Integer> times, int key) {

        int found = -1;

        int left = 0;
        int right = times.size() - 1;

        while (left <= right) {

            int mid = right - (right - left) / 2;

            if (times.get(mid) > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
                found = mid;
            }
        }

        return found >= 0 ? times.get(found) : 0;
    }

    public static void main(String[] args) {

        TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
        obj.set("foo", "bar", 1);
        obj.getAndPrint("foo", 1);
        obj.getAndPrint("foo", 3);
        obj.set("foo", "bar2", 4);
        obj.getAndPrint("foo", 4);
        obj.getAndPrint("foo", 5);
    }

}
