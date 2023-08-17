package rish.leets.contests.biweekly;

/*
 *        BiWeekly Contest 110
 * 
 * Problem #: 2807
 * Contest link: https://leetcode.com/contest/biweekly-contest-110/
 * Problem link: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
 * 
 * Attempt Date: 05/08/2023
 * 
 * @author: Rishabh Soni
 *  
 */
public class InsertGCDLinkedList {

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

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if (head.next == null) {
            return head;
        }

        ListNode ans = new ListNode(head.val);
        ListNode ansCopy = ans;

        ListNode itr = head;
        while (itr.next != null) {

            int a = itr.val;
            int b = itr.next.val;
            int gcd = gcd(a, b);

            ListNode temp1 = new ListNode(gcd);
            ListNode temp2 = new ListNode(b);

            ans.next = temp1;
            temp1.next = temp2;
            ans = temp2;
            itr = itr.next;
        }

        return ansCopy;
    }

    private int gcd(int a, int b) {

        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

}
