/*
 * @lc app=leetcode id=1265 lang=java
 *
 * [1265] Print Immutable Linked List in Reverse
 */

// @lc code=start
/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        preOrder(head);
    }

    private void preOrder(ImmutableListNode node) {
        if (node == null) {
            return;
        }
        // first process next element
        preOrder(node.getNext());
        // print value after all subsequent elements are processed
        node.printValue();
    }
}
// @lc code=end

