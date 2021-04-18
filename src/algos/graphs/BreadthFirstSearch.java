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
            Node[] neighbors = currentNode.neighbors;
            for (Node neighbor : neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    queue.addLast(neighbor);
                }
            }
        }
    }

    static class Node {

        private Node[] neighbors;
        private int value;

        public Node() {

        }

        public Node(int value) {
            this.value = value;
        }

        public Node(Node[] neighbors) {
            this.neighbors = neighbors;
        }

        public Node[] getNeighbors() {
            return neighbors == null ? new Node[]{} : neighbors;
        }

        public int getValue() {
            return value;
        }

        public void setNeighbors(Node[] neighbors) {
            this.neighbors = neighbors;
        }
    }

}
