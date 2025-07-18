// 623. Add One Row to Tree
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

// Note that the root node is at depth 1.

// The adding rule is:

// Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
// cur's original left subtree should be the left subtree of the new left subtree root.
// cur's original right subtree should be the right subtree of the new right subtree root.
// If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 

// Example 1:


// Input: root = [4,2,6,3,1,5], val = 1, depth = 2
// Output: [4,1,1,2,null,null,6,3,1,5]
// Example 2:


// Input: root = [4,2,null,3,1], val = 1, depth = 3
// Output: [4,2,null,1,1,3,null,null,1]
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// The depth of the tree is in the range [1, 104].
// -100 <= Node.val <= 100
// -105 <= val <= 105
// 1 <= depth <= the depth of tree + 1

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        List<TreeNode> ans = levelOrder(root,depth-1);
        for(TreeNode x:ans)
        {
            TreeNode lf = new TreeNode(val);
            lf.left = x.left;
            x.left = lf;
            TreeNode rt = new TreeNode(val);
            rt.right = x.right;
            x.right = rt;
        }
        return root;
    }
    public List<TreeNode> levelOrder(TreeNode root, int d) {
    List<TreeNode> levelNodes = new ArrayList<>();
    if (root == null || d < 1) {
        return levelNodes;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int depth = 1;

    while (!queue.isEmpty()) {
        int size = queue.size();
        List<TreeNode> currentLevel = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            currentLevel.add(node);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        if (depth == d) {
            return currentLevel;
        }

        depth++;
    }

    return levelNodes;
}

}