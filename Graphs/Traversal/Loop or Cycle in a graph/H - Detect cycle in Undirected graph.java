class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        
        // Iterate over all vertices to handle disconnected graphs (not needed if graph is connected)
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                if (dfs(i, -1, visited, adj)) {
                    return true; // If cycle found, return true
                }
            }
        }
        
        // No cycle found
        return false;
    }
    
    // DFS function to detect cycle
    private boolean dfs(int src, int parent, Set<Integer> visited, ArrayList<ArrayList<Integer>> adj) {
        visited.add(src);
        for (int neib : adj.get(src)) {
            // If neighbor is already visited and not the parent, cycle is detected
            if (visited.contains(neib) && neib != parent) {
                return true;
            }
            // If neighbor is not visited, continue DFS
            if (!visited.contains(neib)) {
                if (dfs(neib, src, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}
