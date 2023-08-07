package rish.leets.grind.medium;

import java.util.Stack;

/*
 * Grind 75 : Week 4
 * 
 * Problem #: 155
 * Problem link : https://leetcode.com/problems/min-stack/
 * 
 * Date Attempted: 25/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class MinStack {

    record Pair(int x, long y) {
    }

    private long min;
    private Stack<Pair> stack;

    public MinStack() {
        this.min = Integer.MIN_VALUE - 1;
        this.stack = new Stack<>();
    }

    public void push(int val) {
        // For each new element, keep track of previous minimum
        stack.push(new Pair(val, getMin()));
        this.min = Math.min(min, val);
    }

    public void pop() {
        Pair popped = stack.pop();
        this.min = popped.y();
    }

    public int top() {
        return stack.peek().x();
    }

    public int getMin() {
        return (int) min;
    }

}
