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
    private static void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap); 
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        
        int level = 0;
        while (!queue.isEmpty()) {
            if (level == K) break;
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null && visited.add(node.left)) {
                    queue.add(node.left);
                }
                if (node.right != null && visited.add(node.right)) {
                    queue.add(node.right);
                }
                if (parentMap.containsKey(node) && visited.add(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }
}