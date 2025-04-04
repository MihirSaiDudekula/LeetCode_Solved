// 94. Binary Tree Inorder Traversal
// Easy
// Topics
// Companies
// Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

// Example 1:

// Input: root = [1,null,2,3]

// Output: [1,3,2]

// Explanation:



// Example 2:

// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

// Output: [4,2,6,5,7,1,3,9,8]

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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        List<Integer> l = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left = inorderTraversal(root.left);
        l.addAll(left);
        l.add(root.val);
        right = inorderTraversal(root.right);
        l.addAll(right);
        return l;
    }
}

//alternatively

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        rec(ans,root);
        return ans;
    }
    public static void rec(List<Integer> ans,TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        rec(ans,root.left);
        ans.add(root.val);
        rec(ans,root.right);        
    }
}

