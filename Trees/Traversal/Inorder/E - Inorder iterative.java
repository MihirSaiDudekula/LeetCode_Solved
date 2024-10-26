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
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; 
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); 

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right == null && node.left == null) 
            {
                Node x = stack.pop();
                result.add(x.val);
                continue;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;  

    }
}

// better code
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Push all left nodes to the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop the node and add to result (the "root" part of the inorder)
            current = stack.pop();
            result.add(current.val);

            // Move to the right child of the popped node
            current = current.right;
        }

        return result;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) 
    {
        if(root==null)
        {
            return true;
        }

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

    }
    public static int findHeight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return (Math.abs(left-right));

    }
}