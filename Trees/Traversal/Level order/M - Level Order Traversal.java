// 102. Binary Tree Level Order Traversal
// Solved
// Medium
// Topics
// Companies
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

//there are much better methods but this is something im comfortable with
//using nulls to maintain the levels
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) {
            return ans;
        }
        
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty()) {
            TreeNode x = q.poll();
            
            if (x == null) {
                ans.add(new ArrayList<>(l));
                l.clear();
                if (!q.isEmpty()) { // Only add null if there are more nodes to process
                    q.add(null);
                }
            } else {
                l.add(x.val);
                if (x.left != null) {
                    q.offer(x.left);
                }
                if (x.right != null) {
                    q.offer(x.right);
                }
            }
        }
        
        return ans;    
    }
}


// simpler alt code
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) end = true;
            else{
                if(end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return true;
    }