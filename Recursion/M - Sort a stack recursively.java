// Sort a stack
// Difficulty: MediumAccuracy: 69.19%Submissions: 120K+Points: 4
// Given a stack, the task is to sort it such that the top of the stack has the greatest element.

// Example 1:

// Input:
// Stack: 3 2 1
// Output: 3 2 1
// Example 2:

// Input:
// Stack: 11 2 32 3 41
// Output: 41 32 11 3 2
// Your Task: 
// You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

// Expected Time Complexity: O(N*N)
// Expected Auxilliary Space: O(N) recursive.

// Constraints:
// 1<=N<=100

class GfG {
    // Function to sort a stack such that the greatest element is on top
    public void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Remove the top element
        int top = stack.pop();

        // Recursively sort the remaining stack
        sort(stack);

        // Insert the removed element back into the sorted stack
        insertSorted(stack, top);
    }
    
    // Helper function to insert an element into a sorted stack
    private void insertSorted(Stack<Integer> stack, int element) {
        // If stack is empty or the element is greater than the top element of stack
        if (stack.isEmpty() || stack.peek() < element) {
            stack.push(element);
        } else {
            // Pop all elements that are greater than the element
            int top = stack.pop();
            insertSorted(stack, element);
            // Push the popped elements back onto the stack
            stack.push(top);
        }
    }
}