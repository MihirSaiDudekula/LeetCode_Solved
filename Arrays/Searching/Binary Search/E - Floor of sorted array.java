// Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

// Example 1:

// Input:
// N = 7, x = 0 
// arr[] = {1,2,8,10,11,12,19}
// Output: -1
// Explanation: No element less 
// than 0 is found. So output 
// is "-1".

class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // If current element is smaller than or equal to x,
            // update floorIndex and search in the right half
            if (x < arr[mid]) {
                end = mid - 1;
            } 
            else if (x > arr[mid]) {
                start = mid + 1;
            }
            // If current element is equal to x
            else {
                return mid;
            }
        }
        
        return end;  
    }

    
}
