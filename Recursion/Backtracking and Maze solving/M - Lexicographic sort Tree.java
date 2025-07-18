// 988. Smallest String Starting From Leaf
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

// Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

// As a reminder, any shorter prefix of a string is lexicographically smaller.

// For example, "ab" is lexicographically smaller than "aba".
// A leaf of a node is a node that has no children.

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
import java.util.TreeSet;

class Solution {
    TreeSet<String> set = new TreeSet<>();

    public String smallestFromLeaf(TreeNode root) {
        backtrack(root, new StringBuilder());
        return set.first();
    }

    private void backtrack(TreeNode node, StringBuilder path) {
        if (node == null) return;

        path.insert(0, (char) ('a' + node.val));

        // If it's a leaf, add the string to the TreeSet
        if (node.left == null && node.right == null) {
            set.add(path.toString());
        }

        // Continue traversal
        backtrack(node.left, path);
        backtrack(node.right, path);

        // Backtrack step: remove the character we added
        path.deleteCharAt(0);
    }
}
