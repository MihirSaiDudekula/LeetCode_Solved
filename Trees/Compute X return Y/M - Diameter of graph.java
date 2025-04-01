// 543. Diameter of Binary Tree
// Solved
// Easy
// Topics
// Companies
// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

 

// Example 1:


// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
// Example 2:

// Input: root = [1,2]
// Output: 1
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -100 <= Node.val <= 100

class Solution {
    public int diameterOfBinaryTree(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int maxD = Math.max(leftDiameter,rightDiameter);
        return Math.max((leftDepth+rightDepth),maxD);

    }
    public int maxDepth(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return (Math.max(leftDepth,rightDepth)+1);        
    }
}


//better
public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        //compute 1 thing = required thing = diameter
        max = Math.max(max, left + right);
        
        //but return the other thing = normal thing = depth of tree
        return Math.max(left, right) + 1;
    }
}