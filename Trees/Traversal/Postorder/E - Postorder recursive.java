// 145. Binary Tree Postorder Traversal
// Easy
// Topics
// Companies
// Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

// Example 1:

// Input: root = [1,null,2,3]

// Output: [3,2,1]

// Explanation:



// Example 2:

// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

// Output: [4,6,7,5,2,9,8,3,1]

// Explanation:



// Example 3:

// Input: root = []

// Output: []

// Example 4:

// Input: root = [1]

// Output: [1]

 

// Constraints:

// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        if(root==null)
        {
            return new ArrayList<>();
        }

        List<Integer> l = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left = postorderTraversal(root.left);
        right = postorderTraversal(root.right);
        l.addAll(left);
        l.addAll(right);
        l.add(root.val);
        return l;
        
    }
}