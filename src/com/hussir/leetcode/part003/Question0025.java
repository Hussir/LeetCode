package com.hussir.leetcode.part003;

import com.hussir.leetcode.datastructure.ListNode;

import java.util.Stack;

/**
 * Description:
 *
 *     Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 */
public class Question0025 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (k == 0 || head == null || head.next == null) return head;

        int tempK = k;

        Stack<ListNode> stack = new Stack<>();

        ListNode newHead = null;
        ListNode newTail = null;

        ListNode curCursor = head;

        while (true) {

            if (tempK > 0 && curCursor == null) break;

            if (tempK > 0) {

                stack.push(curCursor);

                curCursor = curCursor.next;

                tempK--;
            } else {

                while (!stack.isEmpty()) {

                    if (newHead == null) {
                        newHead = stack.pop();
                        newTail = newHead;
                    } else {
                        newTail.next = stack.pop();
                        newTail = newTail.next;
                    }
                }

                if (curCursor == null) break;

                tempK = k;
            }
        }

        if (newHead == null) return head;

        if (newTail != null && !stack.isEmpty()) {
            newTail.next = stack.remove(0);
        }else if (newTail != null && stack.isEmpty()) {
            newTail.next = null;
        }

        return newHead;
    }
}
