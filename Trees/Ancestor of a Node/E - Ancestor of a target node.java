//similar to finding a node, but this time find its immeadeate ancestor

public TreeNode ancestorOf(TreeNode root, TreeNode target) {

    if (root == null) {
        return null;
    }

    if (root.left == target || root.right == target) {
        return root; 
    }

    TreeNode leftAncestor = ancestorOf(root.left, target);
    TreeNode rightAncestor = ancestorOf(root.right, target);

    if (leftAncestor != null) {
        return leftAncestor; 
    }

    if (rightAncestor != null) {
        return rightAncestor; 
    }

    return null;
}