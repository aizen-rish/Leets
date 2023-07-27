package rish.leets.grind.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: 150
 * Problem link : https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * Date Attempted: 19/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ReversePolishNotationEvaluator {

    private static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");

    public static int evalRPN(String[] tokens) {

        Stack<Integer> polish = new Stack<>();

        for (String s : tokens) {

            if (OPERATORS.contains(s)) {

                // Pop out operands
                int a = polish.pop();
                int b = polish.pop();

                int ans = eval(s, b, a);
                polish.push(ans);
                continue;
            }

            polish.push(Integer.parseInt(s));
        }

        return polish.pop();
    }

    private static int eval(String operand, int a, int b) {

        switch (operand) {

        case "+":
            return a + b;

        case "-":
            return a - b;

        case "*":
            return a * b;

        case "/":
            return a / b;

        }

        return 0;
    }

    public static void main(String[] args) {

        String[] inp = { "4", "13", "5", "/", "+" };
        System.out.println(evalRPN(inp));
    }

}
