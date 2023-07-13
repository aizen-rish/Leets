package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//

/*
 * Daily Challenge!
 * 
 * Problem #: 207
 * Problem link: https://leetcode.com/problems/course-schedule/
 * 
 * Date Attempted: 14/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CourseDependency {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            return true;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegrees = new int[numCourses];
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

            Integer vis = zeroIndegreeNodes.remove();
            System.out.print(vis + " ");

            for (int node : graph.get(vis)) {
                indegrees[node]--;
                if (indegrees[node] == 0) {
                    zeroIndegreeNodes.add(node);
                }
            }

            visitedNodeCount++;
        }

        System.out.println(" count " + visitedNodeCount);
        return visitedNodeCount == graph.size();
    }

    public static void main(String[] args) {
        int[][] preq = { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } };
        System.out.println(canFinish(5, preq));
    }

}
