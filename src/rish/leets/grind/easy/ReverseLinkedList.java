package rish.leets.grind.easy;

/*
 * Grind 75 : Week 2
 * 
 * Problem #: 206
 * Problem link : https://leetcode.com/problems/reverse-linked-list/
 * 
 * @author Rishabh Soni
 *
 */
public class ReverseLinkedList {

    /*
     * Definition for singly-linked list.
     */
    class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode reverseListRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode hNext = head.next;
        head.next = null;
        ListNode rHead = reverseListRecursive(hNext);
        hNext.next = head;
        return rHead;
    }

    public ListNode reverseListIterative(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode itr = head;
        ListNode rHead = null;

        while (itr != null) {
            ListNode temp = new ListNode(itr.val);
            temp.next = rHead;
            rHead = temp;
            itr = itr.next;
        }

        return rHead;
    }

}
