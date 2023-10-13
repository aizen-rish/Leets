package rish.leets.grind.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Daily Challenge!
 * 
 * Problem #: LC847
 * Problem link: https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 * 
 * Date Attempted: 17/09/2023
 * 
 * @author Rishabh Soni
 *
 */

public class ShortestPathVisitingAllNodes {

    record Pair(int x, int y) {
    }

    class Node {

        int node;
        int mask;
        int cost;

        Node(int node, int mask, int cost) {
            this.node = node;
            this.mask = mask;
            this.cost = cost;
        }
    }

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        Set<Pair> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int maskValue = (1 << i);
            Node node = new Node(i, maskValue, 1);
            q.add(node);
            visited.add(new Pair(i, maskValue));
        }

        /*
         * Solve using BFS and bit mask. As soon as all nodes are visited, return the
         * current cost.
         */

        int all = (1 << n) - 1;
        while (!q.isEmpty()) {

            Node node = q.poll();

            if (node.mask == all) {
                return node.cost - 1;
            }

            for (int adj : graph[node.node]) {

                int combinedMask = node.mask | (1 << adj);
                Node adjNode = new Node(adj, combinedMask, node.cost + 1);

                if (!visited.contains(new Pair(adj, combinedMask))) {
                    visited.add(new Pair(adj, combinedMask));
                    q.add(adjNode);
                }
            }
        }

        return -1;
    }

}
