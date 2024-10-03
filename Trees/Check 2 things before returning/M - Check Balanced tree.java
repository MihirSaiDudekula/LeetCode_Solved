// 110. Balanced Binary Tree
// Easy
// Topics
// Companies
// Given a binary tree, determine if it is 
// height-balanced
// .

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:


// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true
 

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104

class Solution {
    public boolean isBalanced(TreeNode root) 
    {
        if(root==null)
        {
        	return true;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        boolean leftbool = isBalanced(root.left);
        boolean rightbool = isBalanced(root.right);
        boolean feasible = ((leftDepth-rightDepth == 0)||(leftDepth-rightDepth == 1)||(leftDepth-rightDepth == -1))?true:false;

        return (leftbool && rightbool && feasible);

    }
    public static int maxDepth(TreeNode root) 
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

class Solution {
    public boolean checkTree(TreeNode root) 
    {
        if(root==null)
        {
        	return true;
        }

        int leftval = (root.left==null)?0:root.left.val;
        int rightval = (root.left==null)?0:root.left.val;
        boolean leftbool = checkTree(root.left);
        boolean rightbool = checkTree(root.right);
        boolean feasible = ((leftval+rightval)==root.val)?true:false;

        return (leftbool && rightbool && feasible);

    }
    public static int maxSum(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        int leftSum = maxSum(root.left);
        int rightSum = maxSum(root.right);

        return (leftSum+rightSum);        
    }
}