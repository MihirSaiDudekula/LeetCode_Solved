// 279. Perfect Squares
// Solved
// Medium
// Topics
// Companies
// Given an integer n, return the least number of perfect square numbers that sum to n.

// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

// Example 1:

// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
// Example 2:

// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.
 

// Constraints:

// 1 <= n <= 104

class Solution {
    public int numSquares(int n) {
        int x = (int)Math.sqrt(n);
        int[][] arr = new int[x+1][n+1];
        for(int i=0;i<x+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                if(i==0)
                {
                    arr[i][j]=j;
                }
                if(j==0)
                {
                    arr[i][j]=0;
                }
                if(i!=0 && j!=0)
                {
                    int sqr = (i+1)*(i+1);
                    if(j<sqr)
                    {
                        arr[i][j]=arr[i-1][j];
                    }
                    else if(j%sqr==0)
                    {
                        arr[i][j]=j/sqr;
                    }
                    else if(j>sqr && j%sqr!=0)
                    {
                        arr[i][j]=Math.min(arr[i-1][j],(j/sqr)+arr[i-1][j%sqr]);
                    }
                }
            }
        }

        return arr[x][n];
    }
}