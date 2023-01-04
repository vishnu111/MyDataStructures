package com.leetcode.randomquestions;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/?envType=study-plan&id=level-1
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> linkedNodes = new ArrayList<ListNode>();
        while(head != null){
            linkedNodes.add(head);
            head=head.next;
        }
        return linkedNodes.get((int) linkedNodes.size()/2);
    }
}