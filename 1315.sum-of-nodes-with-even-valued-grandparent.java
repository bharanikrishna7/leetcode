/*
 * @lc app=leetcode id=1315 lang=java
 *
 * [1315] Sum of Nodes with Even-Valued Grandparent
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        // if root is null
        // return 0 (since null is not even value)
        if (root == null) {
            return 0;
        }
        int to_add = 0;
        if (root.val % 2 == 0) {
            // add grand kids sum
            to_add = lookAhead(root);
        }
        return to_add +
         // repeat process for root.left
         sumEvenGrandparent(root.left) +
         // repeat process for root.right
         sumEvenGrandparent(root.right);
    }

    /**
      * method to look ahead and sum up the values in
      * grand kids (since it's easier when doing it 
      * in direction root -> leaf)
      * @param node valid grandparent node
      * @return sum of values in grand kids (if present)
      */
    private int lookAhead(TreeNode node) {
        int sum = 0;
        TreeNode left = node.left, right = node.right;
        if (left != null) {
            if (left.left != null) {
                sum += left.left.val;
            }
            if (left.right != null) {
                sum += left.right.val;
            }
        }
        if (right != null) {
            if (right.left != null) {
                sum += right.left.val;
            }
            if (right.right != null) {
                sum += right.right.val;
            }
        }
        return sum;
    }
}
// @lc code=end

