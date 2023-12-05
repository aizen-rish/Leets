package rish.leets.grind.medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Daily Challenge!
 * 
 * Problem #: LC1845
 * 
 * Problem link: https://leetcode.com/problems/seat-reservation-manager/
 * 
 * Date Attempted: 06/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SeatManager {

    private int count;
    private SortedSet<Integer> free;

    public SeatManager(int n) {
        this.count = 0;
        this.free = new TreeSet<>();
    }

    public int reserve() {

        if (free.isEmpty()) {
            count++;
            return count;
        }

        int newSeat = free.first();
        free.remove(newSeat);
        return newSeat;
    }

    public void unreserve(int seatNumber) {

        if (seatNumber == count) {
            count--;
            return;
        }

        free.add(seatNumber);
    }

}
