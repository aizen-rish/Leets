package rish.leets.grind.easy;

/*
 * Grind 75 : Week 2
 *
 * Problem #: 141
 * Problem link : https://leetcode.com/problems/linked-list-cycle/
 *
 * @author Rishabh Soni
 */
public class CyclicLinkedList {

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

  public boolean hasCycle(ListNode head) {

    if (head == null || head.next == null) {
      return false;
    }

    ListNode ptr1 = head;
    ListNode ptr2 = head;

    while (ptr1 != null && ptr2 != null && ptr2.next != null) {

      ptr1 = ptr1.next;
      ptr2 = ptr2.next.next;

      if (ptr1 == ptr2) {
        return true;
      }
    }

    return false;
  }

}
