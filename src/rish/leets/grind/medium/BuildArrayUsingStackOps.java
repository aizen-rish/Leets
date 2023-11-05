package rish.leets.grind.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Daily Challenge!
 * 
 * Problem #: LC1441
 * Problem link: https://leetcode.com/problems/build-an-array-with-stack-operations/
 * 
 * Date Attempted: 03/11/2023
 * 
 * @author Rishabh Soni
 *
 */
public class BuildArrayUsingStackOps {

    private static String PUSH = "Push";
    private static String POP = "Pop";

    public static List<String> buildArray(int[] target, int n) {

        int len = target.length;

        Stack<Integer> stack = new Stack<>();

        List<String> ans = new ArrayList<>();

        int i = 0;
        int j = 1;

        while (i < len) {

            if (target[i] == j) {

                if (!stack.isEmpty()) {

                    if (i == 0) {
                        popTillMatch(stack, target[i], ans);
                    } else if (target[i - 1] != stack.peek()) {
                        popTillMatch(stack, target[i - 1], ans);
                    }
                }

                stack.add(j);
                ans.add(PUSH);
                i++;
            } else if (target[i] > j) {
                stack.add(j);
                ans.add(PUSH);
            }

            j++;
        }

        return ans;
    }

    private static void popTillMatch(Stack<Integer> stack, int element, List<String> ans) {

        while (!stack.isEmpty() && stack.peek() != element) {
            stack.pop();
            ans.add(POP);
        }
    }

    /*
     * Without using extra space
     */
    public static List<String> buildArray2(int[] target, int n) {

        List<String> ans = new ArrayList<>();

        int i = 0;
        int j = 1;

        while (i < target.length) {

            ans.add(PUSH);
            if (target[i] == j) {
                i++;
            } else {
                ans.add(POP);
            }

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] target = { 2, 3, 4 };

        System.out.println(buildArray2(target, 4));
    }

}
