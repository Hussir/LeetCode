package com.hussir.leetcode.part003;

import com.hussir.leetcode.datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description:
 *
 *     Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class Question0023 {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode headNode = null;
        ListNode curNode = null;
        while (!queue.isEmpty()) {

            ListNode minNode = queue.poll();

            if (headNode == null) {
                curNode = minNode;
                headNode = curNode;
            } else {
                curNode.next = minNode;
                curNode = curNode.next;
            }

            if (minNode != null && minNode.next != null) {
                queue.add(minNode.next);
            }
        }

        return headNode;
    }
}
