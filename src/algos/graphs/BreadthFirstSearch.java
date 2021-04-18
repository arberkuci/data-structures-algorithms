package algos.graphs;

import java.util.*;

public class BreadthFirstSearch {

    public void bfs(Node node) {
        LinkedList<Node> queue = new LinkedList();
        queue.addLast(node);
        Set visitedNodes = new HashSet();
        visitedNodes.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.removeFirst();
            Node[] neighbors = currentNode.getNeighbors();
            for (Node neighbor : neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    queue.addLast(neighbor);
                }
            }
        }
    }

}
