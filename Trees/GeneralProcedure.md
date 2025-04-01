Every Tree problem can be solved using these steps

1. there is always a case for `if(root==null){return _}` and otherwise. the check for root being null comes first as we cannot proceed further if it is null, and,

2. all uestions revolve around root,left,right computation.
we need to make sure that we have root left and right of the node are checked.

3. 2 recursions

```java
class Solution {
    public int diameterOfBinaryTree(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int maxD = Math.max(leftDiameter,rightDiameter);
        return Math.max((leftDepth+rightDepth),maxD);

    }
    public int maxDepth(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return (Math.max(leftDepth,rightDepth)+1);        
    }
}

```

notice in the above solution, we are calling 2 different recursions, ie, depth is a seperate recursive function, and diameter is seperate. we need both of these to obtain the diameter of the binary tree

in order to reduce the computations, we have an other method

3. compute something, return other thing

the max variable is effectively shared across all recursive calls in the diameterOfBinaryTree method. This is because max is an instance variable of the Solution class, and all recursive calls to maxDepth operate within the same instance of the Solution class. As a result, any modification to max in one recursive call is visible to all other recursive calls.

Why is max Shared?
In Java:

Instance variables (like max) belong to the object (instance) of the class.

All methods (including recursive ones) within the same instance share access to the same instance variables.

This means max is not local to a specific stack frame but is shared across all stack frames of the recursive calls.

Analogy to Pass-by-Reference
You can think of max as a shared resource that behaves similarly to a pass-by-reference variable:

When max is updated in one recursive call, the change is reflected globally across all recursive calls.

This is because max is not a local variable but an instance variable tied to the object.

```java
public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        //compute 1 thing = required thing = diameter
        max = Math.max(max, left + right);
        
        //but return the other thing = normal thing = depth of tree
        return Math.max(left, right) + 1;
    }
}
```

you cannot modify the recursive function signature to private int maxDepth(TreeNode root, int max) and still solve the problem correctly. Here's why:

Problem with Passing max as a Parameter
Java is Pass-by-Value:

In Java, primitive types (like int) are passed by value. This means that any changes to the max parameter inside the recursive function will not be reflected outside the function.

If you pass max as a parameter, each recursive call will have its own copy of max, and updates to max in one call will not affect other calls.

Loss of Global State:

The original solution relies on max being a shared resource (an instance variable) that is updated globally across all recursive calls.

If you pass max as a parameter, you lose this global state, and the function will no longer correctly track the maximum diameter across the entire tree

## General procedure

base case:

cour recursive function starts with the base case
base case is that case or group of cases that ends the recursion flow 

the most common base case is 
```java
        if(root==null)
        {
            return 0;
        }
```

the easiest way to identify all testcases is to look at the leaf nodes and notice what should end the recursion

it is necessary to identify all the relavent base cases and code them above the recursion calls so that the termination is successful.

Tree recursion calls:

we will make left , right , root calls. the order in which this is done differs based on the question.

```java
int left = rec(root.left)
int right = rec(root.right)
return left+root+right;
```

here in the above example , the order of calling is left , right , root.

root is indicated by the presence of root , and the return

this comes after the base case.

### extra computation variable

sometimes you compute something but return something else
since the computed thing needs to be globally available, initialise a global variable and store in that.

```java
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        //compute 1 thing in the global variable
        max = Math.max(max, left + right);
        
        //but return the other thing = normal recursion = depth of tree
        return Math.max(left, right) + 1;
```


