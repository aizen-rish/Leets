package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 721
 * Problem link : https://leetcode.com/problems/accounts-merge/
 * 
 * Date Attempted: 30/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MergeAccounts {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<String> emails = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Integer> groups = new ArrayList<>();

        int groupIndex = 1;

        for (List<String> account : accounts) {

            int index = -1;
            int emailCount = 0;

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                if (emails.contains(email)) {
                    index = emails.indexOf(email);
                    System.out.println(email + " " + index);
                    continue;
                }

                names.add(name);
                emails.add(email);
                emailCount++;
            }

            int accIndex = index == -1 || index > groups.size() - 1 ? groupIndex++ : groups.get(index);
            for (int i = 0; i < emailCount; i++) {
                groups.add(accIndex);
            }
        }

        List<List<String>> answer = new ArrayList<>();

        // Create answer by groups
        for (int i = 1; i < groupIndex; i++) {

            String name = null;
            TreeSet<String> sub = new TreeSet<>();

            for (int j = 0; j < groups.size(); j++) {
                if (groups.get(j) == i) {
                    sub.add(emails.get(j));
                    name = names.get(j);
                }
            }

            List<String> subAnswer = new ArrayList<>();
            subAnswer.add(name);
            subAnswer.addAll(sub);

            answer.add(subAnswer);
        }

        return answer;
    }

    public static List<List<String>> accountsMerge2(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> account : accounts) {

            String primary = account.get(1);
            graph.putIfAbsent(primary, new ArrayList<>());

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                graph.putIfAbsent(email, new ArrayList<>());
                graph.get(primary).add(email);
                graph.get(email).add(primary);
            }
        }

        List<List<String>> answer = new ArrayList<>();
        Set<String> seenEmails = new HashSet<>();

        for (List<String> account : accounts) {

            String name = account.get(0);
            String primary = account.get(1);

            if (!seenEmails.contains(primary)) {

                List<String> subAnswer = new ArrayList<>();
                subAnswer.add(name);
                subAnswer.addAll(dfs(graph, primary, seenEmails));

                answer.add(subAnswer);
            }
        }

        return answer;
    }

    private static Set<String> dfs(Map<String, List<String>> graph, String start, Set<String> visited) {

        Set<String> res = new TreeSet<>();

        Stack<String> stack = new Stack<>();
        stack.add(start);
        visited.add(start);

        while (!stack.isEmpty()) {

            String vis = stack.pop();
            res.add(vis);

            for (String node : graph.get(vis)) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    stack.add(node);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        List<List<String>> acc = new ArrayList<>();

        acc.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        acc.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        acc.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        acc.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        acc.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));

        System.out.println(accountsMerge2(acc));

    }
}
