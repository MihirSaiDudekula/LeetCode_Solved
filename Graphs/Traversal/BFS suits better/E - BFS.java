import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == 0) {
                visit[i]++;
                bfs(i, graph); // Start BFS from node i
            }
        }
    }

    static void bfs(int nodeIndex, Graph graph) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(graph.allNodes.get(nodeIndex)); // Enqueue the starting node
        visit[nodeIndex] = 1; // Mark the starting node as visited
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll(); // Dequeue a node
            System.out.println(currentNode.data); // Print visited node index
            for (Node neighbor : currentNode.neib) {
                int neighborIndex = neighbor.data;
                if (visit[neighborIndex] == 0) {
                    queue.offer(neighbor); // Enqueue the neighbor if not visited
                    visit[neighborIndex] = 1; // Mark neighbor as visited
                }
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
