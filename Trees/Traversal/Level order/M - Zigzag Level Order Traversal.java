// 103. Binary Tree Zigzag Level Order Traversal
// Solved
// Medium
// Topics
// Companies
// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) {
            return ans;
        }
        
        q.add(root);
        q.add(null);
        int count = 1;

        
        while (!q.isEmpty()) {
            TreeNode x = q.poll();
            
            if (x == null) {
                if(count%2==0)
                {
                    Collections.reverse(l);
                }
                ans.add(new ArrayList<>(l));
                l.clear();
                count++;
                if (!q.isEmpty()) { // Only add null if there are more nodes to process
                    q.add(null);
                }
            } 
            else 
            {
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