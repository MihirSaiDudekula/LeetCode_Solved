// 863. All Nodes Distance K in Binary Tree
// Solved
// Medium
// Topics
// Companies
// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

// You can return the answer in any order.

 

// Example 1:


// Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
// Output: [7,4,1]
// Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
// Example 2:

// Input: root = [1], target = 1, k = 3
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [1, 500].
// 0 <= Node.val <= 500
// All the values Node.val are unique.
// target is the value of one of the nodes in the tree.
// 0 <= k <= 1000

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        // If k == 0, return the target node's value directly
        if (k == 0) {
            return new ArrayList<>(Arrays.asList(target.val));
        }
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, new TreeNode(-1));

        // Step 1: Build the parent map
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            if (x.left != null) {
                queue.offer(x.left);
                map.put(x.left, x);
  
            }
            if (x.right != null) {
                queue.offer(x.right);
                map.put(x.right, x);
  
            }
        }

        // Step 2: BFS to find nodes at distance K
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        q.offer(null); // Level separator
        int times = 0;

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current == null) {
                times++;
                if (times == k) {
                    // Collect all remaining nodes in the queue (those at distance k)
                    while (!q.isEmpty()) {
                        TreeNode x = q.poll();
          
                    }
                    break; // We are done
                }
                // Add a new level separator if we haven't reached distance k
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
  
                // Add unvisited ancestor to the queue
                if (map.get(current) != null && map.get(current).val != -1 && !visited.contains(map.get(current))) {
      
                    q.offer(map.get(current));
                    visited.add(map.get(current)); // Mark as visited
                }
                // Add unvisited left child
                if (current.left != null && !visited.contains(current.left)) {
      
                    q.offer(current.left);
                    visited.add(current.left); // Mark as visited
                }
                // Add unvisited right child
                if (current.right != null && !visited.contains(current.right)) {
      
                    q.offer(current.right);
                    visited.add(current.right); // Mark as visited
                }
            }
        }
        return result;
    }
}
