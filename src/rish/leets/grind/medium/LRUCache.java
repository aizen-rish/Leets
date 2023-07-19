package rish.leets.grind.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Daily Challenge!
 * 
 * Problem #: 146
 * Problem link: https://leetcode.com/problems/lru-cache/
 * 
 * Date Attempted: 19/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> keyRankMap;
    private TreeMap<Integer, Integer> rank;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keyRankMap = new HashMap<>();
        this.rank = new TreeMap<>();
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        updateRank(key);
        return cache.get(key);
    }

    private void updateRank(int key) {
        int currentRank = keyRankMap.get(key);
        rank.remove(currentRank);
        keyRankMap.remove(key);
        insertRank(key);
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            cache.put(key, value);
            updateRank(key);
            return;
        }

        if (cache.size() < capacity) {
            cache.put(key, value);
            insertRank(key);
            return;
        }

        Map.Entry<Integer, Integer> lowestEntry = rank.firstEntry();
        int lruKeyRank = lowestEntry.getKey();
        int lruKey = lowestEntry.getValue();

        cache.remove(lruKey);
        rank.remove(lruKeyRank);
        keyRankMap.remove(lruKey);

        cache.put(key, value);

        insertRank(key);
    }

    private void insertRank(int key) {

        if (rank.isEmpty()) {
            rank.put(0, key);
            keyRankMap.put(key, 0);
            return;
        }

        int newRank = rank.lastKey() + 1;
        rank.put(newRank, key);
        keyRankMap.put(key, newRank);
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}
