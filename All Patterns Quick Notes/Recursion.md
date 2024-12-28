I'll provide a detailed explanation of recursion and its related concepts, using clear examples and building from fundamentals to more complex ideas.

Let's start with a practical example that we'll use throughout - calculating the factorial of a number (5! = 5 × 4 × 3 × 2 × 1). This will help illustrate each point clearly.

1. **The Core Concept of Recursion**
```java
int factorial(int n) {
    if (n == 1) return 1;
    return n * factorial(n-1);  // Recursive call
}
```
When we call `factorial(5)`, each time we hit the recursive call `factorial(n-1)`, it's like starting a new version of our function. Think of it like opening a new copy of the same book - you keep your finger on your current page (line) while starting to read the book again from the beginning with a different number.

2. **The Call Stack - Saving Our Progress**
When calculating factorial(5), each time we make a recursive call, we need to remember where we were and what we were doing. The call stack stores this information like a stack of sticky notes:
```
Note 5: n=5, waiting to multiply by factorial(4)
Note 4: n=4, waiting to multiply by factorial(3)
Note 3: n=3, waiting to multiply by factorial(2)
Note 2: n=2, waiting to multiply by factorial(1)
Note 1: n=1, base case!
```
Each note contains all the local variables and the exact line where we paused.

3. **Stack Operations**
Think of the call stack like a stack of plates. When we make a new recursive call, we put a new plate on top (push). When we return from a call, we take the top plate off (pop). For our factorial example:
```
Push: factorial(5)
Push: factorial(4)
Push: factorial(3)
Push: factorial(2)
Push: factorial(1)  // Base case reached!
Pop: factorial(1) returns 1
Pop: factorial(2) returns 2 * 1
Pop: factorial(3) returns 3 * 2
Pop: factorial(4) returns 4 * 6
Pop: factorial(5) returns 5 * 24
```

4. **Base Cases - The Foundation**
The base case is like the ground floor of a building - it's where we stop digging deeper. Let's look at a string reversal example:
```java
String reverse(String str) {
    // Base case: empty string or single character
    if (str.length() <= 1) {
        return str;  // No need to reverse
    }
    // Recursive case: first character goes to end
    return reverse(str.substring(1)) + str.charAt(0);
}
```

5. **Return Values and References**
When working with data structures, we often need to modify them directly. Here's an example of generating all subsets of a list:
```java
void generateSubsets(List<Integer> nums, List<List<Integer>> result, 
                    List<Integer> current, int index) {
    // The result list is passed by reference and modified directly
    result.add(new ArrayList<>(current));
    
    for (int i = index; i < nums.size(); i++) {
        current.add(nums.get(i));
        generateSubsets(nums, result, current, i + 1);
        current.remove(current.size() - 1);
    }
}
```

6. **Stack Unwinding - The Journey Back**
When a recursive call returns, we continue from exactly where we left off. In merge sort, this is crucial:
```java
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);      // Sort left half
        mergeSort(arr, mid + 1, right); // Sort right half
        merge(arr, left, mid, right);   // Combine results
    }
}
```
After sorting both halves recursively, we combine them using the saved information about where each half begins and ends.

7. **Recursion Trees**
The Fibonacci sequence beautifully demonstrates recursive branching:
```java
int fib(int n) {
    if (n <= 1) return n;
    // Two branches at each step
    int leftBranch = fib(n-1);
    int rightBranch = fib(n-2);
    return leftBranch + rightBranch;
}
```
For fib(5), each call creates two more calls, forming a tree-like structure where each node splits into two branches.

8. **Variable Branching**
In generating permutations, the number of recursive calls varies based on remaining choices:
```java
void permute(List<Integer> nums, List<Integer> current, 
            boolean[] used, List<List<Integer>> result) {
    if (current.size() == nums.size()) {
        result.add(new ArrayList<>(current));
        return;
    }
    // Number of branches depends on remaining unused numbers
    for (int i = 0; i < nums.size(); i++) {
        if (!used[i]) {
            used[i] = true;
            current.add(nums.get(i));
            permute(nums, current, used, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
```

9. **Backtracking**
In the N-Queens problem, we place queens and remove them when we hit dead ends:
```java
boolean solveNQueens(int[][] board, int col, int N) {
    if (col >= N) return true;
    
    for (int row = 0; row < N; row++) {
        if (isSafe(board, row, col)) {
            board[row][col] = 1;  // Place queen
            
            if (solveNQueens(board, col + 1, N)) {
                return true;
            }
            
            board[row][col] = 0;  // Remove queen (backtrack)
        }
    }
    return false;
}
```

10. **Dynamic Programming Extension**
We can improve recursive solutions by remembering previous results:
```java
Map<Integer, Integer> memo = new HashMap<>();

int fibDP(int n) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    
    int result = fibDP(n-1) + fibDP(n-2);
    memo.put(n, result);  // Remember this result
    return result;
}
```
# Recursion Pattern Guide

## 1. Problem Identification
Key indicators that a problem should use recursion:
- Problem can be broken down into smaller, similar sub-problems
- Tree/Graph traversal problems
- Problems involving combinations or permutations
- Need to explore all possibilities (backtracking)
- Keywords like:
  - "All possible ways"
  - "Generate all"
  - "Print all paths"
  - "Find combinations"
  - "Tree traversal"
  - "Divide and conquer"

## 2. General Steps for Solving Recursive Problems

### Basic Steps
1. **Identify Base Case(s)**
   - Simplest possible input
   - Condition to stop recursion
   - Usually handles empty/single element

2. **Define Recursive Case**
   - Break problem into smaller sub-problems
   - Make problem smaller in each call
   - Combine sub-results appropriately

3. **Ensure Progress Towards Base Case**
   - Parameter must move towards base case
   - Avoid infinite recursion
   - Validate input reduction

### Common Recursive Patterns

1. **Linear Recursion**
   - Single recursive call
   - Often used for linear data structures

2. **Binary Recursion**
   - Two recursive calls
   - Common in divide-and-conquer

3. **Multiple Recursion**
   - More than two recursive calls
   - Used in combinatorial problems

4. **Tail Recursion**
   - Recursive call is last operation
   - Can be optimized by compiler

## 3. General Templates

```java
public class RecursionPatterns {
    // Basic Linear Recursion Template
    public int linearRecursion(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Recursive case
        return n + linearRecursion(n - 1);
    }
    
    // Binary Tree Recursion Template
    public void treeRecursion(TreeNode root) {
        // Base case
        if (root == null) {
            return;
        }
        // Process current node
        process(root);
        // Recursive cases
        treeRecursion(root.left);
        treeRecursion(root.right);
    }
    
    // Backtracking Template
    public void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add current combination
        result.add(new ArrayList<>(current));
        
        // Try all possibilities from current position
        for (int i = start; i < nums.length; i++) {
            // Make choice
            current.add(nums[i]);
            // Recurse
            backtrack(result, current, nums, i + 1);
            // Undo choice
            current.remove(current.size() - 1);
        }
    }
    
    // Divide and Conquer Template
    public int divideConquer(int[] arr, int left, int right) {
        // Base case
        if (left == right) {
            return arr[left];
        }
        
        // Divide
        int mid = left + (right - left) / 2;
        
        // Conquer
        int leftResult = divideConquer(arr, left, mid);
        int rightResult = divideConquer(arr, mid + 1, right);
        
        // Combine
        return combine(leftResult, rightResult);
    }
    
    // Path Finding Template
    public void findPaths(int[][] grid, int row, int col, List<String> path, List<List<String>> result) {
        // Base cases
        if (!isValid(grid, row, col)) return;
        if (isDestination(row, col)) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        // Recursive cases - try all directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            path.add(getDirection(dir));
            findPaths(grid, newRow, newCol, path, result);
            path.remove(path.size() - 1);
        }
    }
}
```

## 4. Common Variations

1. **Fibonacci-like Problems**
   - Modification: Track previous states
   - Examples: Climbing stairs, House robber
   - Focus: State dependency

2. **Tree Traversal Variations**
   - Modification: Order of recursion
   - Examples: Pre/In/Post order, Level order
   - Focus: Node processing order

3. **Combinatorial Problems**
   - Modification: Constraint handling
   - Examples: Subsets, Permutations
   - Focus: Choice making and backtracking

4. **Path Finding Problems**
   - Modification: Direction constraints
   - Examples: Maze, Robot paths
   - Focus: Valid move checking

5. **String Generation Problems**
   - Modification: Character choices
   - Examples: Generate parentheses, Letter combinations
   - Focus: Valid string building

## 5. Common Error Solutions

1. **Base Case Handling**
   - Solution: Always handle empty/null inputs
   - Test minimum valid input size
   - Consider all termination conditions

2. **Stack Overflow Prevention**
   - Solution: Validate input size
   - Consider iterative solution for large inputs
   - Use tail recursion when possible

3. **State Management**
   - Solution: Use proper parameter passing
   - Clear state between recursive calls
   - Handle global state carefully

4. **Backtracking Implementation**
   - Solution: Properly undo all changes
   - Track state at each level
   - Handle array modifications correctly

5. **Memory Management**
   - Solution: Avoid creating new objects unnecessarily
   - Reuse objects when possible
   - Clear references when backtracking

## 6. Edge Cases to Consider

1. **Input Size Edge Cases**
   - Empty input
   - Single element input
   - Very large input
   - Maximum recursion depth
   - Invalid input size

2. **Tree/Graph Structure Cases**
   - Empty tree/graph
   - Single node
   - Unbalanced tree
   - Cycle in graph
   - Disconnected components

3. **Array/String Cases**
   - Empty array/string
   - Single character
   - All same elements
   - All different elements
   - Repeated patterns

4. **Numeric Input Cases**
   - Zero/Negative numbers
   - Integer overflow
   - Decimal numbers
   - Maximum/Minimum values
   - Invalid numeric input

5. **Special Structure Cases**
   - Symmetric structures
   - Repeated sub-structures
   - Complex dependencies
   - Circular references
   - Deep nesting