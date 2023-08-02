/*
 * @lc app=leetcode id=2265 lang=java
 *
 * [2265] Count Nodes Equal to Average of Subtree
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
    // this internal object has more properties
    // which will help us in performing required
    // computation in single pass (visiting all nodes exactly once)
    private class SmartTreeNode extends TreeNode {
        int val;
        int nodes;
        int sum;
        SmartTreeNode left;
        SmartTreeNode right;

        SmartTreeNode(int val) {
            this.val = val;
            this.nodes = 1;
            this.sum = val;
        }

        SmartTreeNode(int val, int nodes, int sum) {
            this.val = val;
            this.nodes = nodes;
            this.sum = sum;
        }

        boolean isAverageNode() {
            if (sum / nodes == val) {
                return true;
            } else {
                return false;
            }
        }
    }

    // method which will build (or) generate a smart tree node
    // using supplied tree node
    private SmartTreeNode buildSmartTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        SmartTreeNode node = new SmartTreeNode(root.val);
        if (root.left != null) {
            node.left = buildSmartTree(root.left);
            node.nodes += node.left.nodes;
            node.sum += node.left.sum;
        }
        if (root.right != null) {
            node.right = buildSmartTree(root.right);
            node.nodes += node.right.nodes;
            node.sum += node.right.sum;
        }
        return node;
    }

    // method which will get number of average nodes
    // using our smart tree (since it has all info to do in single BFS / DFS)
    private int averageOfSmartSubTree(SmartTreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.isAverageNode()) {
            return 1 + averageOfSmartSubTree(node.left) + averageOfSmartSubTree(node.right);
        } else {
            return averageOfSmartSubTree(node.left) + averageOfSmartSubTree(node.right);
        }
    }

    // actual method called by leetcode
    public int averageOfSubtree(TreeNode root) {
        return averageOfSmartSubTree(buildSmartTree(root));
    }
}
// @lc code=end

