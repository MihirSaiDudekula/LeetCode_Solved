// 199. Binary Tree Right Side View
// Solved
// Medium
// Topics
// Companies
// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

// Example 1:


// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]
// Example 2:

// Input: root = [1,null,3]
// Output: [1,3]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 1
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) {
            return l;
        }
        
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty()) {
            TreeNode x = q.poll();
            
            if (x == null) {
                if (!q.isEmpty()) { 
                    q.add(null);
                }
            } 
            else {
                if(q.peek()==null)
                {
                    l.add(x.val);
                }
                if (x.left != null) {
                    q.offer(x.left);
                }
                if (x.right != null) {
                    q.offer(x.right);
                }
            }
        }
        return l;
        
    }
}