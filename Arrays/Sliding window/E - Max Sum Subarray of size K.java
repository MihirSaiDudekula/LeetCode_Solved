// Max Sum Subarray of size K

// Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.

// NOTE*: A subarray is a contiguous part of any given array.

// Example 1:

// Input:
// N = 4, K = 2
// Arr = [100, 200, 300, 400]
// Output:
// 700
// Explanation:
// Arr3  + Arr4 =700,
// which is maximum.

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        long cs = 0;
        long ms = 0;

        //for first window - 0 to k-1
        for(int i=0;i<K;i++)
        {
            cs+=Arr.get(i);
        }
        ms=cs;

        //now to slide this window, keep track of element after and before window
        //add element after the current window and subtract element at the start of the window
        
        for(int i=K;i<N;i++)
        {
            cs=cs+Arr.get(i)-Arr.get(i-K);
            if(cs>ms)
            {
                ms=cs;
            }
        }
        return ms;
    }
}