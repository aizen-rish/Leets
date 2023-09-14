package rish.leets.grind.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Daily Challenge!
 * 
 * Problem #: LC332
 * Problem link: https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * Date Attempted: 14/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ReconstructItinerary {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            graph.computeIfAbsent(src, v -> new PriorityQueue<>()).add(dest);
        }

        LinkedList<String> output = new LinkedList<>();

        dfs("JFK", output);

        return output;
    }

    private void dfs(String node, LinkedList<String> output) {

        PriorityQueue<String> pq = graph.getOrDefault(node, new PriorityQueue<>());

        while (!pq.isEmpty()) {
            dfs(pq.poll(), output);
        }

        output.addFirst(node);
    }

    public static void main(String[] args) {

        ReconstructItinerary sol = new ReconstructItinerary();

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("NRT", "JFK"));

        System.out.println(sol.findItinerary(tickets));
    }

}
