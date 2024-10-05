

// Merge k Sorted Arrays
// Difficulty: MediumAccuracy: 67.25%Submissions: 100K+Points: 4
// Given k sorted arrays arranged in the form of a matrix of size k * k. The task is to merge them into one sorted array. Return the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python).


// Examples :

// Input: k = 3, arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
// Output: 1 2 3 4 5 6 7 8 9
// Explanation: Above test case has 3 sorted arrays of size 3, 3, 3 arr[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]. The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
// Input: k = 4, arr[][]={{1,2,3,4},{2,2,3,4},{5,5,6,6},{7,8,9,9}}
// Output: 1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
// Explanation: Above test case has 4 sorted arrays of size 4, 4, 4, 4 arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4], [5, 5, 6, 6], [7, 8, 9, 9 ]]. The merged list will be [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9].
// Expected Time Complexity: O(k2*Log(k))
// Expected Auxiliary Space: O(k2)

// Constraints:
// 1 <= k <= 100

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Write your code here.
        for(int i=0;i<K;i++)
        {
            for(int j=0;j<K;j++)
            {
                pq.add(arr[i][j]);
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        while(!pq.isEmpty())
        {
            l.add(pq.poll());
        }
        return l;
    }
}