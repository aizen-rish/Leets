package rish.leets.grind.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Daily Challenge!
 * 
 * Problem #: LC815
 * 
 * Problem link: https://leetcode.com/problems/bus-routes/submissions/
 * 
 * Date Attempted: 12/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        // create graph between routes
        List<List<Integer>> network = new ArrayList<>();

        int len = routes.length;
        for (int i = 0; i < len; i++) {
            Arrays.sort(routes[i]);
            network.add(new ArrayList<>());
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                if (haveCommon(routes[i], routes[j])) {
                    network.get(i).add(j);
                    network.get(j).add(i);
                }
            }

            if (isStopExist(routes[i], source)) {
                q.add(i);
            }
        }

        Set<Integer> visited = new HashSet<>();
        int busCount = 1;

        while (!q.isEmpty()) {

            int lvl = q.size();
            while (lvl > 0) {

                int node = q.remove();
                if (isStopExist(routes[node], target)) {
                    return busCount;
                }

                for (int nextRoute : network.get(node)) {
                    if (!visited.contains(nextRoute)) {
                        visited.add(nextRoute);
                        q.add(nextRoute);
                    }
                }
                lvl--;
            }

            busCount++;
        }

        return -1;
    }

    boolean isStopExist(int[] route, int stop) {
        for (int j = 0; j < route.length; j++) {
            if (route[j] == stop) {
                return true;
            }
        }
        return false;
    }

    boolean haveCommon(int[] routeA, int[] routeB) {

        int i = 0;
        int j = 0;

        while (i < routeA.length && j < routeB.length) {

            int diff = routeA[i] - routeB[j];
            if (diff == 0) {
                return true;
            }

            if (diff > 0) {
                j++;
            } else {
                i++;
            }
        }

        return false;
    }

}
