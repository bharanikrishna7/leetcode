/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
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
    public int deepestLeavesSum(TreeNode root) {
        // this can be achieved using bfs
        // the sum of nodes in final level is the answer
        int sum = 0;
        LinkedList<TreeNode> bfs = new LinkedList<>();
        LinkedList<TreeNode> process;
        bfs.add(root);
        while (bfs.size() > 0) {
            process = bfs;
            bfs = new LinkedList<>();
            sum = 0;
            for (TreeNode task : process) {
                sum += task.val;
                if (task.left != null) {
                    bfs.add(task.left);
                }
                if (task.right != null) {
                    bfs.add(task.right);
                }
            }
        }
        return sum;
    }
}
// @lc code=end

