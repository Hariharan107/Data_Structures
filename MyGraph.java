import java.util.HashMap;
import java.util.*;

public class MyGraph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    private void printGraph() {
        System.out.println(adjList);
    }

    private boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean RemoveEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        // System.out.println(graph.addEdge("A", "B") ? "Added" : "not added");
        graph.printGraph();
        graph.RemoveEdge("A", "B");
        graph.printGraph();

    }
}