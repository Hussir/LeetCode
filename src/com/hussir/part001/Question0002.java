package com.hussir.part001;

import com.hussir.datastructure.ListNode;

/**
 * Description:
 *
 *     You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 *     You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Question0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode cursor1 = l1;
        ListNode cursor2 = l2;

        ListNode resultCursor = new ListNode(0);
        ListNode resultHead = resultCursor;

        int carry = 0;
        while (cursor1 != null || cursor2 != null || carry != 0) {

            int sum = (cursor1 == null ? 0 : cursor1.val) + (cursor2 == null ? 0 : cursor2.val) + carry;

            carry = sum / 10;

            resultCursor.next = new ListNode(sum % 10);
            resultCursor = resultCursor.next;

            cursor1 = cursor1 == null ? null : cursor1.next;
            cursor2 = cursor2 == null ? null : cursor2.next;
        }

        return resultHead.next;
    }
}
