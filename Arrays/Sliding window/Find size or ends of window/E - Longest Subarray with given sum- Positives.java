// Longest Sub-Array with Sum K
// MediumAccuracy: 24.64%Submissions: 275K+Points: 4
// Be the comment of the day in POTD and win a GfG T-Shirt!
// Solve right now

// banner
// Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

 

// Example 1:
 

// Input :
// A[] = {10, 5, 2, 7, 1, 9}
// K = 15
// Output : 4
// Explanation:
// The sub-array is {5, 2, 7, 1}.

class Solution {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        //Complete the function
        int maxlen = 0;
        int cursum = 0;

        int i = 0;
        int j = 0;
        while (i <= j && j < N) {
            cursum += A[j];
            while (cursum > K) {
                cursum -= A[i];
                i++;
            }
            if (cursum == K) {
                maxlen = Math.max(maxlen, j - i + 1);
            }
            j++;
        }
        return maxlen;
    }
}