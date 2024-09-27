//  Array partition with minimum difference
// Hard
// 120/120
// Average time to solve is 10m
// 351 upvotes
// Asked in companies
// Problem statement
// You are given an array 'arr' containing 'n' non-negative integers.



// Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum.



// You just need to find the minimum absolute difference considering any valid division of the array elements.



// Note:

// 1. Each array element should belong to exactly one of the subsets.

// 2. Subsets need not always be contiguous.
// For example, for the array : [1, 2, 3], some of the possible divisions are 
//    a) {1,2} and {3}
//    b) {1,3} and {2}.

// 3. Subset-sum is the sum of all the elements in that subset. 
// Example:
// Input: 'n' = 5, 'arr' = [3, 1, 5, 2, 8].

// Ouput: 1

// Explanation: We can partition the given array into {3, 1, 5} and {2, 8}. 
// This will give us the minimum possible absolute difference i.e. (10 - 9 = 1).
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 4
// 1 2 3 4
// Sample Output 1:
// 0
// Explanation for sample input 1:
// We can partition the given array into {2,3} and {1,4}.
// This will give us the minimum possible absolute difference i.e. (5 - 5 = 0) in this case.
// Sample Input 2:
// 3
// 8 6 5
// Sample Output 2:
// 3
// Explanation for sample input 2:
// We can partition the given array into {8} and {6,5}. 
// This will give us the minimum possible absolute difference i.e. (11 - 8 = 3).
// Expected time complexity:
// The expected time complexity is O(n * 𝚺 'arr'[i]), where 𝚺 'arr'[i] denotes the sum of all elements in 'arr'.
// Constraints:
// 1 <= 'n' <= 10^3
// 0 <= 'arr'[i] <= 10^3
// 0 <= 𝚺 'arr'[i] <= 10^4, 

// where 𝚺 'arr'[i] denotes the sum of all elements in 'arr'.

// Time Limit: 1sec

class Solution {
    public int minimumDifference(int[] nums) 
    {
        int total = 0;
        for(int x:nums)
        {
            total+=x;
        }
        
        int ans = isSubsetSum(nums.length,nums,total);    
        return ans;
    }
    static int isSubsetSum(int N, int arr[], int total){
        // code here
        int range = total/2;
        boolean[][] t = new boolean[N+1][range+1];
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<=range;j++)
            {
                if(i==0)
                {
                    t[i][j] = false;
                }
                if(j==0)
                {
                    t[i][j] = true;
                }
                if(i>0 && arr[i-1]<=j)
                {
                    t[i][j] = t[i-1][j-arr[i-1]]||t[i-1][j];
                }
                else if(i>0 && arr[i-1]>j)
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        // return t[N][sum];
        int highk = -1;
        for(int k=0;k<=range;k++)
        {
            if(t[N][k]==true && k>highk)
            {
                highk = k;
            }
        }
        return (total-(2*highk));
    }
}
