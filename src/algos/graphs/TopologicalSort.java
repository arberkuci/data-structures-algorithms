package algos.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TopologicalSort {

    public LinkedList<Node> topologicalSort(Graph graph) {
        LinkedList<Node> topologicalSortedNodes = new LinkedList<>();
        dfs(graph, topologicalSortedNodes);
        return topologicalSortedNodes;
    }

    private void dfs(Graph graph, LinkedList<Node> topologicalSort) {
        Set<Node> visited = new HashSet<>();
        for (Node node : graph.getNodes()) {
            if (!visited.contains(node)) {
                visited.add(node);
                visitDfs(node, visited, topologicalSort);
            }
        }
    }

    private void visitDfs(Node node, Set<Node> visited, LinkedList<Node> topologicalSort) {
        Node[] neighbors = node.getNeighbors();
        for (Node neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                visitDfs(neighbor, visited, topologicalSort);
            }
        }
        topologicalSort.addFirst(node);
    }

}
