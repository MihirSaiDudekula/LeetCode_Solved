// 1482. Minimum Number of Days to Make m Bouquets
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given an integer array bloomDay, an integer m and an integer k.

// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 

// Example 1:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
// Example 2:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
// Output: -1
// Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
// Example 3:

// Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
// Output: 12
// Explanation: We need 2 bouquets each should have 3 flowers.
// Here is the garden after the 7 and 12 days:
// After day 7: [x, x, x, x, _, x, x]
// We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
// After day 12: [x, x, x, x, x, x, x]
// It is obvious that we can make two bouquets in different ways.
 

// Constraints:

// bloomDay.length == n
// 1 <= n <= 105
// 1 <= bloomDay[i] <= 109
// 1 <= m <= 106
// 1 <= k <= n

// myy solution
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int[] flower = new int[n];
        if(m*k>n)
        {
            return -1;
        }
        int max = 0;
        for (int x : bloomDay) {
            max = Math.max(max, x);
        }

        int min = 1;
        int ans = -1;
        while(min<=max)
        {
            int mid = min + (max-min)/2;
            Arrays.fill(flower, 0);            
            gardenState(flower,bloomDay,mid);
            if(makeBoq(flower,m,k))
            {   
                ans = mid;   
                max = mid-1;   
            }
            else
            {   
                min=mid+1;   
            }
        }
        return ans;
        
    }
    public void gardenState(int[] flower,int[] bd,int days)
    {
        for(int i=0;i<bd.length;i++)
        {
            if(bd[i]<=days)
            {
                flower[i]=1;
            }
        }
    }
    public boolean makeBoq(int[] arr, int m, int k)
    {
        int count = 0;
        int boqs = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                count++;
   
                if(count == k)
                {
                    boqs++;
       
                    count=0;
       
                }
            }
            else
            {
                count=0;
   
            }
        }
        if(boqs>=m)
        {
            return true;
        }
        return false;
    }
}


//optimised solution
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) return -1;
        
        int min = 1;
        int max = 0;
        for (int x : bloomDay) max = Math.max(max, x);
        
        int ans = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean isPossible(int[] bloomDay, int days, int m, int k) {
        int flowers = 0;
        int bouquets = 0;
        
        for (int day : bloomDay) {
            if (day <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            if (bouquets >= m) return true;
        }
        return bouquets >= m;
    }
}