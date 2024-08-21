class Solution {
    // Memoization array to store Fibonacci numbers
    private int[] memo;

    public int fib(int n) {
        // Initialize the memoization array
        memo = new int[n + 1];
        Arrays.fill(memo, -1); // Fill the array with -1 to denote uncomputed values

        return fibHelper(n,memo);
    }

    private int fibHelper(int n,int[] memo) {
        // Base cases
        if (n == 0) {
            memo[n] = 0;
            return memo[n];
        }
        if (n == 1) {
            memo[1] = 1;
            return memo[n];
        }

        // If already computed, return the value
        if (memo[n] != -1) {
            return memo[n];
        }

        // Compute the Fibonacci number using recursion
        memo[n] = fibHelper(n - 1,memo) + fibHelper(n - 2,memo);
        return memo[n];
    }
}
