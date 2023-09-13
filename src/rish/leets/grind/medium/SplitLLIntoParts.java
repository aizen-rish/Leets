package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: LC725
 * Problem link: https://leetcode.com/problems/split-linked-list-in-parts/
 * 
 * Date Attempted: 06/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class SplitLLIntoParts {

    public static ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] ans = new ListNode[k];

        if (head == null) {
            return ans;
        }

        ListNode itr = head;

        int size = 0;
        while (itr != null) {
            size++;
            itr = itr.next;
        }

        int spill = size % k;
        int share = size / k;

        for (int i = 0; i < k; i++) {

            int subSize = share;

            if (spill > 0) {
                subSize++;
                spill--;
            }

            head = linkAndAppend(ans, head, i, subSize);

            if (head == null) {
                return ans;
            }
        }

        return ans;
    }

    private static ListNode linkAndAppend(ListNode[] ans, ListNode head, int pos, int size) {

        System.out.println(head.val + " " + pos + " " + size);

        int i = 1;
        ListNode itr = head;

        while (i < size && itr != null) {
            i++;
            itr = itr.next;
        }

        ans[pos] = head;
        ListNode temp = null;

        if (itr != null) {
            temp = itr.next;
            itr.next = null;
        }

        return temp;
    }

    private static void printList(ListNode head) {

        ListNode itr = head;

        while (itr != null) {
            System.out.print(itr.val + " ");
            itr = itr.next;
        }
    }

    public static void main(String[] args) {

        ListNode z = new ListNode(10);
        ListNode y = new ListNode(9, z);
        ListNode x = new ListNode(8, y);
        ListNode w = new ListNode(7, x);
        ListNode v = new ListNode(6, w);
        ListNode u = new ListNode(5, v);
        ListNode t = new ListNode(4, u);
        ListNode s = new ListNode(3, t);
        ListNode r = new ListNode(2, s);
        ListNode q = new ListNode(1, r);
        ListNode p = new ListNode(0, q);

        ListNode[] ans = splitListToParts(p, 11);

        for (ListNode test : ans) {
            System.out.println();
            printList(test);
        }
    }

}

/*
 * Definition for singly-linked list.
 */
class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
