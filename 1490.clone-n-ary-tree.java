/*
 * @lc app=leetcode id=1490 lang=java
 *
 * [1490] Clone N-ary Tree
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        // if root is null
        // then return null
        if (root == null) {
            return null;
        }
        // create a brand new node
        // using constructor (crucial)
        Node node = new Node(root.val);
        // for each child
        for (Node child : root.children) {
            // perform clone task and add to node children
            node.children.add(cloneTree(child));
        }
        // return node (newly deep copied tree node)
        return node;
    }
}
// @lc code=end

