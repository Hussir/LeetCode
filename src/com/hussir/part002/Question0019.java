package com.hussir.part002;

import com.hussir.datastructure.ListNode;

/**
 * Description:
 *
 *     Given a linked list, remove the n-th node from the end of list and return its head.
 */
public class Question0019 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode rightCursor = head;
        for (int i = 1; i < n; i++) {
            rightCursor = rightCursor.next;
        }

        ListNode preCursor = null;
        ListNode leftCursor = head;

        while (rightCursor.next != null) {
            preCursor = leftCursor;
            leftCursor = leftCursor.next;
            rightCursor = rightCursor.next;
        }

        if (preCursor == null) {
            return head.next;
        }

        preCursor.next = leftCursor.next;

        return head;
    }
}
