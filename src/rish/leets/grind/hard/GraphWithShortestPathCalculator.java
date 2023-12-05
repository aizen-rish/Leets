package rish.leets.grind.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Daily Challenge!
 * 
 * Problem #: LC2642
 * 
 * Problem link:
 * https://leetcode.com/problems/design-graph-with-shortest-path-calculator/
 * 
 * Date Attempted: 11/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class GraphWithShortestPathCalculator {

    class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    private int[][] graph;
    private int size;

    public GraphWithShortestPathCalculator(int n, int[][] edges) {
        this.size = n;
        this.graph = new int[n][n];
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        addEdgeInternal(edge[0], edge[1], edge[2]);
    }

    private void addEdgeInternal(int from, int to, int weight) {
        graph[from][to] = weight;
    }

    public int shortestPath(int node1, int node2) {

        int[] distance = new int[size];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.distance, y.distance));

        distance[node1] = 0;
        pq.add(new Pair(0, node1));

        while (!pq.isEmpty()) {

            Pair u = pq.poll();
            int vis = u.node;
            int dist = u.distance;

            for (int i = 0; i < size; i++) {

                if (graph[u.node][i] != 0) {

                    int edgeWeight = graph[vis][i];

                    if (dist + edgeWeight < distance[i]) {
                        distance[i] = dist + edgeWeight;
                        pq.add(new Pair(distance[i], i));
                    }
                }
            }
        }

        if (distance[node2] == Integer.MAX_VALUE) {
            distance[node2] = -1;
        }

        return distance[node2];
    }

}
