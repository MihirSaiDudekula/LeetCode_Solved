// Topological sort
// Difficulty: MediumAccuracy: 56.52%Submissions: 245K+Points: 4
// Given an adjacency list for a Directed Acyclic Graph (DAG) where adj[u] contains a list of all vertices v such that there exists a directed edge u -> v. Return topological sort for the given graph.

// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
// Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be 1 else 0.

// Examples:

// Input: adj = [[], [0], [0], [0]] 

// Output: 1
// Explanation: The output 1 denotes that the order is valid. Few valid Topological orders for the given graph are:
// [3, 2, 1, 0]
// [1, 2, 3, 0]
// [2, 3, 1, 0]
// Input: adj = [[], [3], [3], [], [0,1], [0,2]]

// Output: 1
// Explanation: The output 1 denotes that the order is valid. Few valid Topological orders for the graph are:
// [4, 5, 0, 1, 2, 3]
// [5, 2, 4, 0, 1, 3]
// Constraints:
// 2  ≤  V  ≤  103
// 1  ≤  E  ≤  (V * (V - 1)) / 2

class Solution {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int len = adj.size();
        int[] visited = new int[len];
        Stack<Integer> topo = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            if (visited[i] == 0) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                
                while (!stack.isEmpty()) {
                    int node = stack.peek();
                    
                    if (visited[node] == 0) {
                        visited[node] = 1;
                        boolean allNeighborsProcessed = true;
                        
                        for (int neighbor : adj.get(node)) {
                            if (visited[neighbor] == 0) {
                                stack.push(neighbor);
                                allNeighborsProcessed = false;
                            }
                        }
                        
                        if (allNeighborsProcessed) {
                            visited[node] = 2;
                            topo.push(node);
                            stack.pop();
                        }
                    } 
                    else if (visited[node] == 1) 
                    {
                        break;
                    } 
                    else 
                    {
                        stack.pop();
                    }
                }
            }
        }
        
        while (!topo.isEmpty()) {
            ans.add(topo.pop());
        }
        
        return ans;
    }
}

class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        int[] ans = new int[numCourses];
        int index = 0;
        List<List<Integer>> l = new ArrayList<>();
        int[] visited = new int[numCourses];
        // Arrays.fill(visited,-1);
        for (int i = 0; i < numCourses; i++) 
        {
            l.add(new ArrayList<>());
        }
        for(int[] x:prerequisites)
        {
            // l.add(x[1],x[0]);
            l.get(x[1]).add(x[0]);
        }
        for(int i = 0; i < numCourses; i++)
        {
            if(visited[i]==0)
            {
                Stack<Integer> s = new Stack<>();
                Stack<Integer> topo = new Stack<>();
                s.push(i);
                visited[i]++;
                while(!s.isEmpty())
                {
                    int a = s.peek();
                    boolean allNeighborsProcessed = true;
                    // ans[index++]=a;
                    List<Integer> nb = l.get(a);
                    for(int k:nb)
                    {
                        if(visited[k]==0)
                        {
                            s.push(k);
                            visited[k]++;
                            allNeighborsProcessed = false;
                        }
                    }

                    if(allNeighborsProcessed)
                    {
                    	visited[a]++;
                    	topo.push(s.pop());
                    }
                }
            }
        }
        while (!topo.isEmpty()) 
        {
            ans[index++]=topo.pop();
        }
        
        return ans;
    }
}