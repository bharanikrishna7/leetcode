/*
 * @lc app=leetcode id=2181 lang=java
 *
 * [2181] Merge Nodes in Between Zeros
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        // if head is null return head
        if (head == null) {
            return head;
        }
        if (head.val == 0) {
            // if head is 0 move forward
            head = head.next;
        } else {
            // if head.val is not 0
            if (head.next != null) {
                // check next exists
                if (head.next.val != 0) {
                    // if next val is not zero
                    // then update current node val
                    // discard next node
                    head.val += head.next.val;
                    head.next = head.next.next;
                } else {
                    // discard next node
                    // move head forward (since sum here is complete)
                    head.next = head.next.next;
                    head = head.next;
                }
            } else {
                // if next does not exist
                // then move head forward
                head = head.next;
            }
        }
        // chain-the command
        mergeNodes(head);
        return head;
    }
}
// @lc code=end

