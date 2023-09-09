package rish.leets.grind.medium;

/*
 * Daily Challenge!
 * 
 * Problem #: LC92
 * Problem link: https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Date Attempted: 07/09/2023
 * 
 * @author Rishabh Soni
 *
 */
public class ReverseLinkedList2 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head.next == null || left == right) {
            return head;
        }

        ListNode ans = head;

        ListNode attachPoint = null;
        ListNode revHead = null;
        ListNode revItr = revHead;

        int i = 1;
        ListNode itr = head;

        while (itr != null) {

            if (i < left) {
                attachPoint = itr;
            } else if (i > right) {
                revItr.next = itr;
                break;
            } else {
                ListNode temp = new ListNode(itr.val);
                if (revHead == null) {
                    revItr = temp;
                } else {
                    temp.next = revHead;
                }
                revHead = temp;
            }

            i++;
            itr = itr.next;
        }

        if (attachPoint == null) {
            return revHead;
        }

        if (revHead != null) {
            attachPoint.next = revHead;
        }

        return ans;
    }

}
