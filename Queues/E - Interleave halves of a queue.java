// Interleave the First Half of the Queue with Second Half
// Difficulty: MediumAccuracy: 76.94%Submissions: 7K+Points: 4
// You are given a queue Q of N integers of even length, rearrange the elements by interleaving the first half of the queue with the second half of the queue.

 

// Example 1:

// Input:
// N = 4
// Q = {2,4,3,1}
// Output:
// {2,3,4,1}
// Explanation:
// After the mentioned rearrangement of the first half
// and second half, our final queue will be {2,3,4,1}.
 

// Example 2:

// Input:
// N = 2
// Q = {3,5}
// Output:
// {3,5}
// Explanation:
// After the mentioned rearrangement of the first half
// and second half, our final queue will be {3,5}.
 

// Your Task:

// You don't need to read input or print anything. Your task is to complete the function rearrangeQueue() which takes a queue Q as input and returns the modified queue after the rearrangement.

 

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N)

 

// Constraints:
// 2 <= N <= 105
// N is even
// 1 <= Elements of Queue <= 103
// Sum of N over all test cases doesn't exceeds 106

class Solution {
    public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
        // code here
        Queue<Integer> sec = new LinkedList<>();
        for(int i=0;i<N/2;i++)
        {
            sec.offer(q.poll());
        }
        for(int i=0;i<N/2;i++)
        {
            sec.offer(sec.poll());
            sec.offer(q.poll());
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while(!sec.isEmpty())
        {
            arr.add(sec.poll());
        }
        return arr;
    }
}
        
