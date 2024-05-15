// Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

// Example 1:

// Input:
// N = 7, X = 2
// Arr[] = {1, 1, 2, 2, 2, 2, 3}
// Output: 4
// Explanation: 2 occurs 4 times in the
// given array.
// Example 2:

// Input:
// N = 7, X = 4
// Arr[] = {1, 1, 2, 2, 2, 2, 3}
// Output: 0
// Explanation: 4 is not present in the
// given array.
// Your Task:
// You don't need to read input or print anything.
// Your task is to complete the function count() which takes the array of integers arr, n, and x as parameters and returns an integer denoting the answer.
// If x is not present in the array (arr) then return 0.

// Expected Time Complexity: O(logN)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 ≤ N ≤ 105
// 1 ≤ Arr[i] ≤ 106
// 1 ≤ X ≤ 106



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int fpos = firstpos(arr,0,arr.length-1,x);
        int lpos = lastpos(arr,0,arr.length-1,x);
        int c = -1;
        if(fpos==-1)
        {
        	//obviosly if fpos=-1, lpos must be -1 
        	//it indicates abscence of element
            c=0;
        }
        else
        {
            c = lpos-fpos+1;
        }
        return c;
    }
    public int firstpos(int[] arr,int low,int high,int target)
    {
        // int mid= -1;
        int fp = -1;
        while(low<=high)
        {
            int mid = low+((high-low)/2);
            if(arr[mid]==target)
            {
                fp=mid;
                high=mid-1;
            }
            else if(arr[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return fp;
    }

    public int lastpos(int[] arr,int low,int high,int target)
    {
        // int mid=-1;
        int lp =-1;
        while(low<=high)
        {
            int mid = low+((high-low)/2);
            if(arr[mid]==target)
            {
                lp=mid;
                low=mid+1;
            }
            else if(arr[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return lp;
    }
}

