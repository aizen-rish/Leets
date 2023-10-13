package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: LC86
 * Problem link: https://leetcode.com/problems/partition-list/
 * 
 * Date Attempted: 15/08/2023
 * 
 * @author Rishabh Soni
 *
 */
public class PartitionList {

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

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode less = null;
        ListNode more = null;
        ListNode lessHead = null;
        ListNode moreHead = null;

        ListNode itr = head;

        while (itr != null) {

            ListNode temp = new ListNode(itr.val);

            if (itr.val < x) {
                if (less == null) {
                    lessHead = temp;
                } else {
                    less.next = temp;
                }
                less = temp;
            } else {
                if (more == null) {
                    moreHead = temp;
                } else {
                    more.next = temp;
                }
                more = temp;
            }

            itr = itr.next;
        }

        if (lessHead == null) {
            lessHead = moreHead;
        } else {
            less.next = moreHead;
        }

        return lessHead;
    }

}
