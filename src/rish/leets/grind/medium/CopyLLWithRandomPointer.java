package rish.leets.grind.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Daily Challenge!
 * 
 * Problem #: LC138
 * Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Date Attempted: 05/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class CopyLLWithRandomPointer {

    Map<Node, Node> map = new HashMap<>();

    class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        Node ans = null;
        Node ansItr = null;

        Node itr = head;

        while (itr != null) {

            Node temp = generateCopy(itr);

            if (ans == null) {
                ans = temp;
            } else {
                ansItr.next = temp;
            }

            ansItr = temp;
            itr = itr.next;
        }

        return ans;
    }

    private Node generateCopy(Node node) {

        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node temp = new Node(node.val);
        map.put(node, temp);

        temp.random = generateCopy(node.random);
        map.put(node, temp);

        return temp;
    }

}
