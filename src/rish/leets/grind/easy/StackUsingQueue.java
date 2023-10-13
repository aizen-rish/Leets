package rish.leets.grind.easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Daily Challenge!
 * 
 * Problem #: 225
 * Problem link: https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * Date Attempted: 28/08/2023
 * 
 * @author Rishabh Soni
 *
 */
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        int popped = getLastElement2();
        q1.remove(popped);
        return popped;
    }

    private int getLastElement() {

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int ele = q1.poll();

        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }

        return ele;
    }

    public int top() {
        return getLastElement2();
    }

    private int getLastElement2() {

        int last = 0;
        Iterator<Integer> it = q1.iterator();

        while (it.hasNext()) {
            int ele = it.next();
            if (!it.hasNext()) {
                last = ele;
            }
        }

        return last;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

}

public class StackUsingQueue {

    public static void main(String[] args) {

        MyStack s = new MyStack();

        s.push(1);
        s.push(2);

        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }

}
