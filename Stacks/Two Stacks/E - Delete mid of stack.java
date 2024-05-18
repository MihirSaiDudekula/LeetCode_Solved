// Delete middle element of a stack
// EasyAccuracy: 53.71%Submissions: 129K+Points: 2
// Find better job opportunities this summer via Job-A-Thon Hiring Challenge!

// banner
// Given a stack, delete the middle element of the stack without using any additional data structure.
// Middle element:- floor((size_of_stack+1)/2) (1-based indexing) from bottom of the stack.

// Note: The output shown by the compiler is the stack from top to bottom.
 
// Example 1:

// Input: 
// Stack = {10, 20, 30, 40, 50}
// Output:
// ModifiedStack = {10, 20, 40, 50}
// Explanation:
// If you print the stack the bottom-most element will be 10 and the top-most element will be 50. Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like {10 20 40 50}.
// Example 2:

// Input: 
// Stack = {10 20 30 40}
// Output:
// ModifiedStack = {10 30 40}
// Explanation:
// If you print the stack the bottom-most element will be 10 and the top-most element will be 40. Middle element will be element at index 2 from bottom, which is 20. Deleting 20, stack will look like {10 30 40}.

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        Stack<Integer> extra = new Stack<>();
        int size = s.size();
        int ttm = -1;
        // ttm - no of elements to pop before i get to mid element
        if(size%2==0)
        {
            ttm=(size/2);
        }
        else
        {
            ttm=((size+1)/2)-1;
        }
        for(int i=0;i<ttm;i++)
        {
            extra.push(s.pop());
        }
        s.pop();
        while(!extra.empty())
        {
            s.push(extra.pop());
        }
        
    } 
}
