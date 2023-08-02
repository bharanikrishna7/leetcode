/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
 */

// @lc code=start

import java.util.Arrays;

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        // find the index where max value is present
        int max_index = -1, max_value = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] > max_value) {
                max_value = nums[i];
                max_index = i;
            }
        }
        // this max index will be root node of this array
        TreeNode root = new TreeNode(nums[max_index]);
        // System.out.println("generated node : " + root.val);
        
        // not set root.left by performing same operation of sub array [0, max_index - 1]
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, max_index));
        // not set root.right by performing same operation of sub array [max_index + 1, nums.length - 1]
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, max_index + 1, nums.length));
        return root;
    }
}
// @lc code=end

