package com.hussir.leetcode.part003;

import com.hussir.leetcode.datastructure.ListNode;

/**
 * Description:
 *
 *     Given a linked list, swap every two adjacent nodes and return its head.
 */
public class Question0024 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;

        ListNode preCursor = null;
        ListNode curCursor = head;

        while (curCursor != null && curCursor.next != null) {

            if (preCursor != null) {
                preCursor.next = curCursor.next;
            }

            preCursor = curCursor;

            ListNode nextNode = curCursor.next;
            ListNode tempNode = nextNode.next;

            nextNode.next = curCursor;
            curCursor.next = tempNode;

            curCursor = tempNode;
        }

        if (curCursor != null && preCursor != null) {
            preCursor.next = curCursor;
        }

        return newHead;
    }
}
