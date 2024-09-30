// 144. Binary Tree Preorder Traversal
// Solved
// Easy
// Topics
// Companies
// Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

// Example 1:

// Input: root = [1,null,2,3]

// Output: [1,2,3]

// Explanation:



// Example 2:

// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

// Output: [1,2,4,5,6,7,3,8,9]

// Explanation:



// Example 3:

// Input: root = []

// Output: []

// Example 4:

// Input: root = [1]

// Output: [1]

 

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        //without using a helper function and without changing function signature, this is the way
        List<Integer> l = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        l.add(root.val);
        left = preorderTraversal(root.left);
        right = preorderTraversal(root.right);
        l.addAll(left);
        l.addAll(right);
        return l;
    }
}

//using a helper function
// public List<Integer> preorderTraversal(TreeNode root) {
//     List<Integer> result = new ArrayList<>();
//     preorderHelper(root, result);
//     return result;
// }

// private void preorderHelper(TreeNode node, List<Integer> result) {
//     if (node == null) {
//         return; // Base case: if the node is null, return
//     }
//     result.add(node.val); // Visit the node
//     preorderHelper(node.left, result); // Traverse left
//     preorderHelper(node.right, result); // Traverse right
// }
