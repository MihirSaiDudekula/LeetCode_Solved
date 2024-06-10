import java.util.ArrayList;

class Node {
    int data;
    ArrayList<Node> neib;

    public Node(int val) {
        this.data = val;
        this.neib = new ArrayList<>();
    }

    public void addNeib(Node n) {
        this.neib.add(n);
    }
}

class Graph {
    ArrayList<Node> allNodes;

    public Graph() {
        this.allNodes = new ArrayList<>();
    }
}

class DFS {
    static int[] visit;

    public static void main(String[] args) {
        Graph graph = createGraph(); // Create the graph
        visit = new int[graph.allNodes.size()]; // Initialize visit array
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == 0) {
                visit[i]++;
                dfs(i, graph); // Start DFS from node i
            }
        }
    }

    static void dfs(int nodeIndex, Graph graph) {
        System.out.println(nodeIndex); // Print visited node index
        for (Node neighbor : graph.allNodes.get(nodeIndex).neib) {
            if (visit[neighbor.data] == 0) {
                visit[neighbor.data]++;
                dfs(neighbor.data, graph); // Recursively call DFS for the neighbor node
            }
        }
    }

    static Graph createGraph() {
        Graph graph = new Graph();
        // Create nodes
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        // Add nodes to the graph
        graph.allNodes.add(node0);
        graph.allNodes.add(node1);
        graph.allNodes.add(node2);
        // Define edges
        node0.addNeib(node1);
        node1.addNeib(node2);
        node2.addNeib(node0);
        return graph;
    }
}
