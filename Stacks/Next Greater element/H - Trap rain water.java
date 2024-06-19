// 42. Trapping Rain Water
// Solved
// Hard
// Topics
// Companies
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] bigInR = new int[n];
        int[] bigInL = new int[n];
        int maxl = -1;
        int maxr = -1;
        int totalw = 0;
        for(int i=0;i<n;i++)
        {
            if(height[i]>=maxl)
            {
                maxl=height[i];
            }
            bigInL[i]=maxl;
        }
        for(int i=n-1;i>=0;i--)
        {
            if(height[i]>=maxr)
            {
                maxr=height[i];
            }
            bigInR[i]=maxr;
        }
        for(int j=0;j<n;j++)
        {
            totalw+=((Math.min(bigInL[j],bigInR[j]))-height[j]);
            System.out.println(totalw);
        }
        return totalw;
    }
}