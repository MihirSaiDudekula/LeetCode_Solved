// First negative integer in every window of size k

// Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

// Example 1:

// Input : 
// N = 5
// A[] = {-8, 2, 3, -6, 10}
// K = 2
// Output : 
// -8 0 -6 -6
// Explanation :
// First negative integer for each window of size k
// {-8, 2} = -8
// {2, 3} = 0 (does not contain a negative integer)
// {3, -6} = -6
// {-6, 10} = -6
//  

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        Queue<Long> q = new LinkedList<>();
        long[] res = new long[N - K + 1];
        int count = 0;
        
        // Process the first window of size K
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                q.offer(A[i]);
            }
        }
        
        // Store the result for the first window
        res[count++] = q.isEmpty() ? 0 : q.peek();
        
        // Process the rest of the windows
        for (int i = K; i < N; i++) {
            if (A[i] < 0) {
                q.offer(A[i]);
            }
            if (A[i - K] < 0 && q.peek() == A[i - K]) {
                q.poll();
            }
            res[count++] = q.isEmpty() ? 0 : q.peek();
        }
        
        return res;
    }
}
