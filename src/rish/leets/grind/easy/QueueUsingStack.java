package rish.leets.grind.easy;

import java.util.Stack;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 232
 * Problem link : https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * @author Rishabh Soni
 *
 */
class MyQueue {

	private Stack<Integer> s1;
	private Stack<Integer> s2;

	private boolean isOrdered;

	public MyQueue() {
		this.s1 = new Stack<>();
		this.s2 = new Stack<>();
		this.isOrdered = false;
	}

	public void push(int x) {

		if (isOrdered) {
			reverseFill(s2, s1);
			isOrdered = false;
		}

		s1.push(x);
	}

	public int pop() {

		if (isOrdered) {
			return s2.pop();
		}

		// If not ordered, reverse elements
		reverseFill(s1, s2);
		isOrdered = true;
		return s2.pop();
	}

	public int peek() {

		if (isOrdered) {
			return s2.peek();
		}

		// If not ordered, reverse elements
		reverseFill(s1, s2);
		isOrdered = true;
		return s2.peek();
	}

	private void reverseFill(Stack<Integer> src, Stack<Integer> dest) {

		if (src.empty()) {
			return;
		}

		while (!src.empty()) {
			dest.add(src.pop());
		}
	}

	public boolean empty() {
		return isOrdered ? s2.empty() : s1.empty();
	}

}

public class QueueUsingStack {

	public static void main(String[] args) {

		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);

		System.out.println(q.peek());
		System.out.println(q.pop());
		System.out.println(q.pop());
	}

}
