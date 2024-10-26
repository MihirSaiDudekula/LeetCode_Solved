//check for the prescence of a value in the tree


// note value could be an int instead of a treenode
public boolean whereTarget(TreeNode root, TreeNode value) {
    // Base case: If the root is null, the target is not found.
    if (root == null) {
        return false;
    }

    // Check if the current node's value matches the target node's value.
    if (root.val == value.val) { // Compare root value with the target's value
        return true;
    }

    // Recursively check the left and right subtrees.
    boolean left = whereTarget(root.left, value); // Pass 'value' to the recursive call
    boolean right = whereTarget(root.right, value); // Pass 'value' to the recursive call

    // If the target is found in either subtree, return true.
    return left || right; // Simplified return statement
}



//lets modify the above code to return the node if found , and null if not found
public TreeNode whereTarget(TreeNode root, int value) {
    if (root == null) {
        return null;
    }

    if (root.val == value) {
        return root;
    }

    TreeNode left = whereTarget(root.left, value); 
    TreeNode right = whereTarget(root.right, value);

   
    if (left != null) 
    {
    	//found in left (lhs)
        return left;
    }
    if (right != null) 
    {
    	// found in right (rhs)
        return right;
    }
    //not found on either side - not present in our tree
    return null;
}
