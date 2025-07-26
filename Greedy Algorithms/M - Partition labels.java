// 763. Partition Labels
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

// Return a list of integers representing the size of these parts.

 

// Example 1:

// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
// Example 2:

// Input: s = "eccbbbbdec"
// Output: [10]
 

// Constraints:

// 1 <= s.length <= 500
// s consists of lowercase English letters.

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] firstInx = new int[26];
        int[] lastInx = new int[26];
        Arrays.fill(firstInx,-1);
        Arrays.fill(lastInx,-1);
        for(int i=0;i<s.length();i++)
        {
            if(firstInx[s.charAt(i)-'a']==-1)
            {
                firstInx[s.charAt(i)-'a']=i;
            }
            lastInx[s.charAt(i)-'a']=i;
        }

        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i=0;i<26;i++)
        {
            if(firstInx[i]>=0 && lastInx[i]>0)
            {
                pq.offer(new int[]{firstInx[i],lastInx[i]});
            }
        }

        while(!pq.isEmpty())
        {
            int[] prev = pq.poll();
            if(pq.isEmpty())
            {
                //only one interval
                result.add(prev[1]-prev[0]+1);
                break;
            }
            int[] curr = pq.poll();
            if(prev[1]>=curr[0])
            {
                pq.offer(new int[]{Math.min(prev[0],curr[0]),Math.max(prev[1],curr[1])});
            }
            else
            {
                result.add(prev[1]-prev[0]+1);
                pq.offer(curr);
            }
        }

        return result;
    }
}