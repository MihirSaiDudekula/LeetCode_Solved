import java.util.ArrayList;
import java.util.Stack;

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

public class Main {
    static int[] visit;

    public static void main(String[] args) {
        Graph graph = createGraph(); // Create the graph
        visit = new int[graph.allNodes.size()]; // Initialize visit array
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == 0) {
                visit[i]++;
                dfs(i, graph, stack); // Start DFS from node i
            }
        }
        // Print the topological ordering by popping elements from the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static void dfs(int nodeIndex, Graph graph, Stack<Integer> stack) {
        for (Node neighbor : graph.allNodes.get(nodeIndex).neib) {
            if (visit[neighbor.data] == 0) {
                visit[neighbor.data]++;
                dfs(neighbor.data, graph, stack); // Recursively call DFS for the neighbor node
            }
        }
        // After visiting all neighbors, push the current node into the stack
        stack.push(nodeIndex);
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
