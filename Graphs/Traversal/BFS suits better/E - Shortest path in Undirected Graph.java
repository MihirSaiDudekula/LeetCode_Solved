// Shortest path in Undirected Graph

// You are given an Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.

// Example1:

// Input:
// n = 9, m= 10
// edges=[[0,1],[0,3],[3,4],[4,5],[5,6],[1,2],[2,6],[6,7],[7,8],[6,8]] 
// src=0
// Output:
// 0 1 2 1 2 3 3 4 4
// - It is the array of minimum distance to that element ex: 0 is 0 steps away from 0, 1step away from 1, 2 steps away from 2 ...

class Solution {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        List < List < Integer >> adjl = new ArrayList < > (n);
        for (int i = 0; i < n; i++) {
            adjl.add(new ArrayList < > ());
        }
        for (int i = 0; i < m; i++) {
            adjl.get(edges[i][0]).add(edges[i][1]);
            adjl.get(edges[i][1]).add(edges[i][0]);
        }
        Queue < Integer > q = new LinkedList < > ();
        Set < Integer > visit = new HashSet < > ();
        q.offer(src);
        visit.add(src);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neib: adjl.get(curr)) {
                if (!visit.contains(neib)) {
                    q.offer(neib);
                    dist[neib] = dist[curr] + 1;
                    visit.add(neib);
                }
            }
        }
        return dist;
    }

}