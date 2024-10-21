// 236. Lowest Common Ancestor of a Binary Tree
// Solved
// Medium
// Topics
// Companies
// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

// Example 1:


// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
// Example 2:


// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
// Example 3:

// Input: root = [1,2], p = 1, q = 2
// Output: 1
 

// Constraints:

// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root,new TreeNode(-1));

        while(!queue.isEmpty())
        {
            TreeNode x = queue.poll();
            if(x.left!=null)
            {
                queue.offer(x.left);
                map.put(x.left,x);
            }
            if(x.right!=null)
            {
                queue.offer(x.right);
                map.put(x.right,x);
            }
        }

        List<TreeNode> pans = genAncestors(p,map);
        List<TreeNode> qans = genAncestors(q,map);

        TreeNode comans = findUniqueElement(pans,qans);
        return comans;

    }
    public static List<TreeNode> genAncestors(TreeNode root,HashMap<TreeNode,TreeNode> map)
    {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        ans.add(root);
        while(map.get(root).val!=-1)
        {
            ans.add(map.get(root));
            root = map.get(root);
        }
        return ans;
    }
    public static TreeNode findUniqueElement(List<TreeNode> list1, List<TreeNode> list2) {
        HashSet<TreeNode> set = new HashSet<>();

        for (TreeNode num : list1) {
            set.add(num);
        }

        for (TreeNode num : list2) {
            if (set.contains(num)) {
                return num; 
            }
        }

        return new TreeNode(-1); 
    }

}

//better solution
// Let's break down the problem first and then convert it into Java.

// ### Problem Explanation:
// You are given a binary tree, and two nodes `p` and `q`. The goal is to find the **lowest common ancestor (LCA)** of these two nodes in the binary tree. The lowest common ancestor of two nodes `p` and `q` in a tree is defined as the deepest node that is an ancestor of both `p` and `q`.

// #### Intuition:
// 1. If the current node (`root`) is either `p` or `q`, then that node itself could be an ancestor, so we return it.
// 2. If neither `p` nor `q` is found at the current node, we recursively explore the left and right subtrees:
//    - If we find `p` or `q` in both the left and right subtrees, then the current node is their lowest common ancestor.
//    - If only one of them is found, we return the node we found (`left` or `right`) to continue the search.
// 3. If neither node is found in either subtree, return `null`.

// ### Java Code:
// Here's the translation of the C++ code into Java:

// ```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;  // Base case: if the root is null, return null
        if (root.val == p.val || root.val == q.val) return root;  // If the current node is p or q, return it

        // Recur to the left and right subtree
        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);

        // If p and q are found in both the left and right subtree, the current node is their LCA
        if (left != null && right != null) return root;

        // If one of the sides is null, return the non-null side
        if (left == null) return right;
        return left;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p, q);  // Call the helper function
    }
}
// ```

// ### Intuitive Breakdown:

// Let's walk through the logic:

// 1. **Base Case:**
//    - If the `root` is `null`, we return `null`. This means that we've reached a leaf node (end of a path) without finding either `p` or `q`.
//    - If the current `root` matches either `p` or `q`, return the current node because it could be an ancestor.

// 2. **Recursive Exploration:**
//    - We recursively search both the left and right subtrees for `p` and `q`.
//    - If both `p` and `q` are found in different subtrees (i.e., `left` is not `null` and `right` is not `null`), that means the current node is the lowest common ancestor because `p` is in one subtree and `q` is in the other (or vice versa).

// 3. **Returning Nodes:**
//    - If one subtree returns `null`, this means `p` and `q` were not found in that subtree, so we return the non-null subtree where `p` or `q` was found.
//    - If both subtrees return `null`, it means `p` and `q` were not found in either subtree, and we return `null`.

// ### Why This Solution Works:

// The solution works based on a **post-order traversal** approach:
// - We explore the entire left subtree.
// - Then the entire right subtree.
// - Only afterward do we check the current node.

// During the recursion:
// - If `p` and `q` are found in separate branches of the tree (left and right), the current node is their LCA.
// - If both `p` and `q` are found in one branch, we bubble up the result and continue the search until we find the node that is an ancestor to both `p` and `q`.

// Thus, by using recursion, the solution efficiently searches for `p` and `q`, and when it encounters a node where both values diverge into different branches, it identifies that node as the LCA.

