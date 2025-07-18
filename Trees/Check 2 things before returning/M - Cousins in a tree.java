/**
993. Cousins in Binary Tree
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.
**/

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // Base case: if root is null
        if (root == null) {
            return false;
        }
        
        // If root is a leaf node
        if(root.left == null && root.right == null) {
            // A leaf can't have cousins
            return false;
        }
        
        // Check if x and y are siblings (same parent) - need null checks
        if((root.left != null && root.right != null) && 
           ((root.left.val == x && root.right.val == y) || 
            (root.left.val == y && root.right.val == x))) {
            return false;
        }

        // Get depth of x and y from left and right subtrees
        int leftDepth = getDepth(root.left, x, y, 1);
        int rightDepth = getDepth(root.right, x, y, 1);

        // If both found at same depth, they are cousins
        if(leftDepth > 0 && rightDepth > 0) {
            if(leftDepth == rightDepth) {
                return true;
            }
        }
        
        // If not found in different subtrees, continue searching
        return isCousins(root.left, x, y) || isCousins(root.right, x, y);
    }
    
    // Helper method to find depth of target values
    private int getDepth(TreeNode node, int x, int y, int depth) {
        if (node == null) {
            return -1;
        }
        
        if (node.val == x || node.val == y) {
            return depth;
        }
        
        int leftResult = getDepth(node.left, x, y, depth + 1);
        int rightResult = getDepth(node.right, x, y, depth + 1);
        
        return Math.max(leftResult, rightResult);
    }
}