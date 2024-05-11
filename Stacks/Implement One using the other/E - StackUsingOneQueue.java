// 225. Implement Stack using Queues
// Solved
// Easy
// Topics
// Companies
// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

// Implement the MyStack class:

// void push(int x) Pushes element x to the top of the stack.
// int pop() Removes the element on the top of the stack and returns it.
// int top() Returns the element on the top of the stack.
// boolean empty() Returns true if the stack is empty, false otherwise.
// Notes:

// You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
// Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

// Example 1:

// Input
// ["MyStack", "push", "push", "top", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 2, 2, false]

// Explanation
// MyStack myStack = new MyStack();
// myStack.push(1);
// myStack.push(2);
// myStack.top(); // return 2
// myStack.pop(); // return 2
// myStack.empty(); // return False
 

// Constraints:

// 1 <= x <= 9
// At most 100 calls will be made to push, pop, top, and empty.
// All the calls to pop and top are valid.
 

// Follow-up: Can you implement the stack using only one queue?

class MyStack {
    private static Queue<Integer> q1;
    // private static Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<Integer>();        
        // q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
            // // Push x first in empty q2
            // q2.add(x);
 
            // // Push all the remaining
            // // elements in q1 to q2.
            // while (!q1.isEmpty()) {
            //     q2.add(q1.peek());
            //     q1.remove();
            // }
 
            // // swap the names of two queues
            // Queue<Integer> q = q1;
            // q1 = q2;
            // q2 = q;
                int size = q1.size();
    
                // Add the new element to the end of q1
                q1.add(x);
    
                // Rotate the queue to make the newly added element at the front
                for (int i = 0; i < size; i++) {
                    q1.add(q1.remove());
                }
    }
    
    public int pop() {
            // if no elements are there in q1
            if (q1.isEmpty())
                return -1;
            return q1.remove();
    }
    
    public int top() {
        if (q1.isEmpty())
            return -1;
        int k = q1.peek();
        return k;
        
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */