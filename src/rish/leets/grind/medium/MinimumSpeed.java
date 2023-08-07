package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Daily Challenge!
 * 
 * Problem #: 1870
 * Problem link: https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
 * 
 * Date Attempted: 26/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MinimumSpeed {

    public static int minSpeedOnTime(int[] dist, double hour) {

        int len = dist.length;
        if (Math.ceil(hour) < len) {
            return -1;
        }

        if (Arrays.stream(dist).sum() <= hour) {
            return 1;
        }

        int left = 1;
        int right = (int) 10e7;

        int possibleSpeed = -1;

        while (left <= right) {
            int mid = left - (left - right) / 2;
            double timeTaken = calculateTime(dist, mid);
            System.out.println(" mid : " + mid + " time : " + timeTaken);
            if (timeTaken > hour) {
                left = mid + 1;
            } else {
                right = mid - 1;
                possibleSpeed = mid;
            }
        }

        return possibleSpeed;
    }

    private static double calculateTime(int[] dist, double speed) {

        double ata = 0.0;
        for (int i = 0; i < dist.length; i++) {
            double time = dist[i] / speed;
            if (i != dist.length - 1) {
                time = Math.ceil(time);
            }
            ata += time;
        }

        return ata;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 2 };

        System.out.println(minSpeedOnTime(arr, 6));
    }

}
