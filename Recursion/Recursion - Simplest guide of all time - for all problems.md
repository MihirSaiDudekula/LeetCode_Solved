1. Recursion is basically a function calling itself. within the function body,whenever we encounter a call to the same function(recursive call), we need to go back to the first line of the function body and start executing again.

2.But just before going back to line 1, we push all our current progress (the variables,etc.) into a function call stack.

3.on each function call, the call is added to the call stack and whenever we encounter the `return` statement, the function is popped from the call stack

4.so, this process of adding to call stack goes on until a base case is satisfied. base case is that case of recursion which indicates the end of the process. usually, it is determined by one of the variables that are saved in the call stack(in point no.2)
`syntax`
```java
if(/*condition*/)
{
	/*final remaining process*/
	return;
}
```

5.the return value of the recursion depends on what type of data the function returns. the variables and data structures like(arraylist,set,etc) must be passed by reference for modification of the actual structure. so if the current function doesnt have the required return type and parameters, define a new function and recurse it.

6. once a particular call reaches return, it exits from the call stack and goes back to the `next line of the previous call`. that is -> it goes back to the line which had called it and continues from there. the data for that is stored at the topmost call of the call stack.

7.while drawing the recursion tree of the recursion. for a particular node , the number of branches that emerge out from it , is equal to the number of recursive calls in the code.

ex: in fibonacci sequence code :
`return fibo(n-1)+fibo(n-2)`

can be re written as 
`int x = fibo(n-1)
 int y = fibo(n-2)
 return x+y`

 so if n were to be 5, from 5, the node for 4 originates on 1 side and 3 originates on the other side. this indicates the prescence of 2 recursive calls in single function body - a hint in problem solving.

this is more apparent in permutations questions and merge sort algo

8.The number of branches need not be constant either,(like fibo has a constant 2), in permutation based problems, it varies at each level, so these calls are then put into for/while loops.

```java
for (i=0;i<n;i++) {
	funcs(a,b,i);
}
```

8.5:
### **Understanding Recursion in Java: Parameters vs. Local Variables with Data Structures**  

Just like in Python, when a recursive function is called in Java, each call has **its own execution context**. However, Java has **pass-by-value semantics**, which behaves differently for **primitive types** and **objects (including lists, arrays, trees, etc.)**.

### **Key Observations in Java**  
1. **Primitive types (like `int`, `double`) are passed by value** – Each recursive call gets a **new copy** of the primitive.  
2. **Objects (like `ArrayList`, arrays, trees) are passed by reference** – The reference to the object is passed by value, meaning all recursive calls operate on the **same object in memory**.
3. **Each recursive call has its own stack frame**, meaning local variables inside the function **are unique to each call**.

---

## **Example 1: Modifying a List Recursively**
Let’s implement the equivalent of `modify_list()` from Python in Java:

```java
import java.util.*;

public class RecursionExample {
    public static void modifyList(List<Integer> lst, int i) {
        if (i == lst.size()) {
            return; // Base case
        }
        lst.set(i, lst.get(i) + 1); // Modify list in place
        modifyList(lst, i + 1); // Recursive call with updated index
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 3));
        modifyList(lst, 0);
        System.out.println(lst); // Output: [2, 3, 4]
    }
}
```

### **How Variables Are Handled Here?**  

| Call                  | `lst` (Same Object) | `i` (New Copy) |
|----------------------|---------------------|----------------|
| `modifyList([1,2,3], 0)`  | `[2,2,3]`   | `i = 0` |
| `modifyList([2,2,3], 1)`  | `[2,3,3]`   | `i = 1` |
| `modifyList([2,3,3], 2)`  | `[2,3,4]`   | `i = 2` |

### **Key Takeaways:**
- `lst` is a **mutable object**, and since Java passes object **references** by value, **all function calls modify the same list in memory**.
- `i` is a **primitive integer**, so **each recursive call gets a new copy** of `i`, isolating its value across different calls.
- **Each recursive call gets a new workspace**, where local variables exist **only for that call**.

---

## **Building Intuition for Backtracking and Tree Problems**  

### **Backtracking Example: Generating All Subsequences**
Backtracking problems rely on **passing a reference to a mutable data structure** (e.g., `ArrayList`) while ensuring **each recursive call has its own state**.

```java
import java.util.*;

public class Subsets {
    public static void generateSubsets(List<Integer> nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.size()) {
            result.add(new ArrayList<>(current)); // Store a copy of current
            return;
        }
        
        // Exclude the current element
        generateSubsets(nums, index + 1, current, result);
        
        // Include the current element
        current.add(nums.get(index));
        generateSubsets(nums, index + 1, current, result);
        
        // Backtrack (remove last added element)
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        System.out.println(result);
    }
}
```

### **How Variables Are Handled in Each Recursive Call?**
| Call | `index` (New Copy) | `current` (Same Object, Modified) |
|------|------------------|--------------------------------|
| `generateSubsets([1,2,3], 0, [])` | `0` | `[]` |
| `generateSubsets([1,2,3], 1, [])` | `1` | `[]` |
| `generateSubsets([1,2,3], 2, [])` | `2` | `[]` |
| `generateSubsets([1,2,3], 2, [3])` | `2` | `[3]` |
| `generateSubsets([1,2,3], 1, [2])` | `1` | `[2]` |

### **Key Observations for Backtracking:**
- The `current` list **remains the same object**, but each function call **modifies and restores it (backtracks)**.
- `index` is **passed by value**, meaning each call **gets a unique copy of `index`**.
- **A copy of `current` is stored at the base case** to prevent unwanted modifications in future calls.

---

## **Tree Problems: Recursion with Nodes**
Recursion is commonly used to traverse trees. Since **nodes are objects**, they are **passed by reference**, allowing modifications across recursive calls.

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class TreeTraversal {
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        inorder(root); // Output: 2 1 3
    }
}
```

### **How Variables Are Handled Here?**
- `root` is a **mutable object (TreeNode)**, so all function calls operate on the same memory object.
- `root.left` and `root.right` are **different references**, allowing traversal.
- Each recursive call gets a **new stack frame**, maintaining its own `root` reference.

---

## **Building Intuition for Recursion and Backtracking**
1. **Each recursive call is an isolated instance**: It has **its own copy of primitive values** but **shares mutable objects**.
2. **Lists and trees (mutable objects) are modified in-place**: They **persist across calls**, requiring careful handling in backtracking.
3. **Backtracking restores state before returning**: We must **undo changes** before returning to the previous call to avoid corruption.
4. **Tree traversal follows a natural recursive structure**: Recursive calls **process subtrees** while retaining the root node reference.



9.Backtracking: is the process in which we revert any changes made to the shared data structure (the array, which is modified at each recursion call), to which if we hadd added something , we need to remove before exiting from the stack after the reuired work is completed.

```java
  combo.add(candidates[i]);
  backtrack(candidates, combo, sum+ candidates[i], target, result, i);
  combo.remove(combo.size() - 1);
```

we make an addition to the combo array,then we remove the addition,
note the sum variable , it doesnt need subtraction in the backtracking part, simply because, 
1. its a uniue value for each fn call in the stack
2. its not modified in the function body,it is modified only when passing, so dont have to change it later 


10.DP is an extension of multiple recursion. the idea is to memoize existing recursion trees instead of rebuilding them

