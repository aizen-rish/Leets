package rish.leets.grind.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Daily Challenge!
 * 
 * Problem #: LC2050
 * Problem link: https://leetcode.com/problems/parallel-courses-iii/
 * 
 * Date Attempted: 18/10/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ParallelCourses3 {

    public int minimumTime(int n, int[][] relations, int[] time) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int[] edge : relations) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            indegree[edge[1] - 1]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] totalTime = new int[n];

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                totalTime[i] = time[i];
            }
        }

        while (!q.isEmpty()) {

            int course = q.remove();

            for (int edge : graph.get(course)) {

                int newTime = totalTime[course] + time[edge];
                totalTime[edge] = Math.max(totalTime[edge], newTime);
                indegree[edge]--;

                if (indegree[edge] == 0) {
                    q.add(edge);
                }
            }
        }

        return Arrays.stream(totalTime).max().getAsInt();
    }

}
