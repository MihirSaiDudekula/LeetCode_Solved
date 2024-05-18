// Next Greater Element (NGE) for every element in given Array
// Last Updated : 29 Sep, 2023
// Given an array, print the Next Greater Element (NGE) for every element. 

// The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1. 

// Example: 

// Input: arr[] = [ 4 , 5 , 2 , 25 ]
// Output:  4      –>   5
//                5      –>   25
//                2      –>   25
//               25     –>   -1
// Explanation: except 25 every element has an element greater than them present on the right side

// Input: arr[] = [ 13 , 7, 6 , 12 ]
// Output:  13      –>    -1
//                 7       –>     12
//                 6       –>     12
//                12      –>     -1
// Explanation: 13 and 12 don’t have any element greater than them present on the right side

//IDEA
// the top of the stack should contain the closest value large than given value,followed by the subsequent values

class Solution {
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) { 
        long[] nle = new long[n];
        Stack<Long> st = new Stack<>();
        // Initialize nle with -1 for all elements, to watch out for corner cases.
        Arrays.fill(nle, -1);
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if(st.isEmpty()==false)
            {
                nle[i] = st.peek();
            }
            else
            {
                nle[i] = -1;
            }
            st.push(arr[i]);
        }
        return nle;
    } 
}