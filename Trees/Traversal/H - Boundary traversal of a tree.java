// Given a Binary Tree, perform the boundary traversal of the tree. The boundary traversal is the process of visiting the boundary nodes of the binary tree in the anticlockwise direction, starting from the root.
// means, the leftmost, bottom leaves and rightmost nodes forming a circle in anticlockwise way


class Solution {
    List<Integer> result = new ArrayList<>();
    Stack<Integer> rightBoundary = new Stack<>();
    
    public List<Integer> boundaryTraversal(TreeNode root) {
        if (root == null) return result;
        
        // Add root
        result.add(root.val);
        
        // Process left boundary
        processLeftBoundary(root.left);
        
        // Process leaf nodes (excluding the ones that are part of left or right boundary)
        processLeaves(root.left);
        processLeaves(root.right);
        
        // Process right boundary (reversed order)
        processRightBoundary(root.right);
        
        // Add right boundary nodes from stack
        while (!rightBoundary.isEmpty()) {
            result.add(rightBoundary.pop());
        }
        
        return result;
    }
    
    private void processLeftBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        
        result.add(node.val);
        
        if (node.left != null) {
            processLeftBoundary(node.left);
        } else {
            processLeftBoundary(node.right);
        }
    }
    
    private void processRightBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        
        rightBoundary.push(node.val);
        
        if (node.right != null) {
            processRightBoundary(node.right);
        } else {
            processRightBoundary(node.left);
        }
    }
    
    private void processLeaves(TreeNode node) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        
        processLeaves(node.left);
        processLeaves(node.right);
    }
}