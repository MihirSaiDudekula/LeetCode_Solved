// 1080. Insufficient Nodes in Root to Leaf Paths
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given the root of a binary tree and an integer limit, delete all insufficient nodes in the tree simultaneously, and return the root of the resulting binary tree.

// A node is insufficient if every root to leaf path intersecting this node has a sum strictly less than limit.

// A leaf is a node with no children.


class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null) {
            return null;
        }
        
        // If this is a leaf node, check if path sum >= limit
        if(root.left == null && root.right == null) {
            if(root.val < limit) {
                return null;  // Remove this leaf
            } else {
                return root;  // Keep this leaf
            }
        }
        
        // Recursively process children with updated limit
        TreeNode left = sufficientSubset(root.left, limit - root.val);
        TreeNode right = sufficientSubset(root.right, limit - root.val);
        
        // Update the children
        root.left = left;
        root.right = right;
        
        // If both children are removed, this node should also be removed
        if(left == null && right == null) {
            return null;
        }
        
        return root;
    }
}