// Number of NGEs to the right
// Difficulty: MediumAccuracy: 61.77%Submissions: 10K+Points: 4
// Given an array of N integers and Q queries of indices, print the number of next greater elements(NGEs) to the right of the given index element. 
// Example:

// Input:  arr     = [3, 4, 2, 7, 5, 8, 10, 6]
//         queries = 2
//         indices = [0, 5]
// Output:  6, 1
// Explanation:  
// The next greater elements to the right of 3(index 0)
// are 4,7,5,8,10,6.  
// The next greater elements to the right of 8(index 5)
// is only 10.

// Your Task:
// You don't need to read or print anything. Your task is to complete the function count_NGEs() which takes N, arr, queries and indices as the input parameter and returns a list NGEs[] where NGEs[i] stores the count of elements strictly greater than the current element (arr[indices[i]]) to the right of indices[i]

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    int[] ans = new int[indices.length];
    Stack<Integer> s = new Stack<>();
    int count=0;
    for(int i=0;i<indices.length;i++)
    {
        for(int j=indices[i]+1;j<arr.length;j++)
        {
            if(arr[j]>arr[indices[i]])
            {
                s.push(arr[j]);
            }
        }
        ans[count]=s.size();
        count++;
        s.clear();
    }
    return ans;
  }
}