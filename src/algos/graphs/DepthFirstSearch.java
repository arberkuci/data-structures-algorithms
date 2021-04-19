package algos.graphs;

import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {

    public void dfs(Graph graph) {
        Set<Node> visited = new HashSet<>();
        for (Node node : graph.getNodes()) {
            if (!visited.contains(node)) {
                visited.add(node);
                visitDfs(node, visited);
            }
        }
    }

    private void visitDfs(Node node, Set<Node> visited) {
        Node[] neighbors = node.getNeighbors();
        for (Node neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                visitDfs(neighbor, visited);
            }
        }
    }

}
