package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: 207
 * Problem link : https://leetcode.com/problems/course-schedule/
 * 
 * Date Attempted: 14/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CourseScheduleSolver {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegrees = new int[graph.size()];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] js = prerequisites[i];
            graph.get(js[0]).add(js[1]);
            indegrees[js[1]]++;
        }

        Queue<Integer> zeroIndegreeNodes = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                zeroIndegreeNodes.add(i);
            }
        }

        int visitedNodeCount = 0;
        while (!zeroIndegreeNodes.isEmpty()) {

            int vis = zeroIndegreeNodes.remove();
            for (int node : graph.get(vis)) {
                indegrees[node]--;
                if (indegrees[node] == 0) {
                    zeroIndegreeNodes.add(node);
                }
            }

            visitedNodeCount++;
        }

        return visitedNodeCount == graph.size();
    }

}
