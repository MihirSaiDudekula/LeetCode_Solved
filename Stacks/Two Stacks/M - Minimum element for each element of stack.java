// 155. Min Stack
// Medium
// Topics
// Companies
// Hint
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.whats the error?

class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;
    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();        
    }
    
    public void push(int val) {
        s.push(val);
        if(min.size()==0)
        {
            min.push(val);
        }
        else
        {
            min.push(Math.min(min.peek(),val));
        }
    }
    
    public void pop() {
        s.pop();
        min.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

