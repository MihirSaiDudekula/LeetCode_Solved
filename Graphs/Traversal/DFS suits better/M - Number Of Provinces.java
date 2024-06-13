// 547. Number of Provinces
// Solved
// Medium
// Topics
// Companies
// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.

import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjl = conAdjmtoAdjl(isConnected);
        int noofnodes = isConnected.length;
        boolean[] visit = new boolean[noofnodes];
        int count = 0;

        for (int i = 0; i < noofnodes; i++) {
            if (!visit[i]) {
                count++;
                bfs(i, adjl, visit);
            }
        }
        return count;    
    }

    public void bfs(int n, List<List<Integer>> adjl, boolean[] v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        v[n] = true;  // Mark the node as visited when it's first encountered
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int t : adjl.get(x)) {
                if (!v[t]) {
                    v[t] = true;
                    q.offer(t);
                }
            }
        }
    }

    public List<List<Integer>> conAdjmtoAdjl(int[][] isConnected) {
        List<List<Integer>> l = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());  // Initialize each list in the adjacency list
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    l.get(i).add(j);
                    l.get(j).add(i);
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(sol.findCircleNum(isConnected));  // Output: 2
    }
}
