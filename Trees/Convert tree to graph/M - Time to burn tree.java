// 2385. Amount of Time for Binary Tree to Be Infected
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

// Each minute, a node becomes infected if:

// The node is currently uninfected.
// The node is adjacent to an infected node.
// Return the number of minutes needed for the entire tree to be infected.

 

// Example 1:


// Input: root = [1,5,3,null,4,10,6,9,2], start = 3
// Output: 4
// Explanation: The following nodes are infected during:
// - Minute 0: Node 3
// - Minute 1: Nodes 1, 10 and 6
// - Minute 2: Node 5
// - Minute 3: Node 4
// - Minute 4: Nodes 9 and 2
// It takes 4 minutes for the whole tree to be infected so we return 4.
// Example 2:


// Input: root = [1], start = 1
// Output: 0
// Explanation: At minute 0, the only node in the tree is infected so we return 0.
 

// Constraints:

// The number of nodes in the tree is in the range [1, 105].
// 1 <= Node.val <= 105
// Each node has a unique value.
// A node with a value of start exists in the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        TreeNode target = find(root,start);
        if(target==null)
        {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,TreeNode> map = parentMap(root);
        Set<Integer> visited = new HashSet<>();
        q.offer(target);
        visited.add(target.val);
        q.offer(null);
        int count = 0;
        
        while(!q.isEmpty())
        {
            TreeNode x = q.poll();
            if(x==null)
            {
                count++;
                if(!q.isEmpty())
                {
                    q.offer(null);
                }
            }
            else{
                if(x.left!=null && !visited.contains(x.left.val))
                {
                    q.offer(x.left);
                    visited.add(x.left.val);
                }
                if(x.right!=null && !visited.contains(x.right.val))
                {
                    q.offer(x.right);
                    visited.add(x.right.val);
                }
                if(map.containsKey(x))
                {
                    if(!visited.contains(map.get(x).val))
                    {
                        q.offer(map.get(x));
                        visited.add(map.get(x).val);
                    }
                }

            }
        }

        return count-1;
    }
    public HashMap<TreeNode,TreeNode> parentMap(TreeNode root)
    {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode x = q.poll();
            if(x.left!=null)
            {
                map.put(x.left,x);
                q.offer(x.left);
            }
            if(x.right!=null)
            {
                map.put(x.right,x);
                q.offer(x.right);
            }
        }
        return map;
    }
    public TreeNode find(TreeNode root,int target)
    {
        if(root==null)
        {
            return null;
        }

        if(root.val==target)
        {
            return root;
        }


        TreeNode left = find(root.left,target);
        TreeNode right = find(root.right,target);

        if(left==null && right==null)
        {
            return null;
        }

        if(left!=null)
        {
            return left;
        }

        if(right!=null)
        {
            return right;
        }

        return null;
    }
}