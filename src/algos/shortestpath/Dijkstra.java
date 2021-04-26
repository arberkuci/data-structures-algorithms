package algos.shortestpath;

import java.util.*;

public class Dijkstra {

    public Map<Node, Integer> shortestPath(WeightedDirectedGraph graph, Node source) {
        Map<Node, Integer> distances = new HashMap<>();
        //Using a hash map because java does not offer an efficient and complete implementation of a heap ds.
        //Using a hash map, extract min is O(n) where n is the number of processed nodes.
        Map<Node, Integer> processedNodes = new HashMap<>();
        initialize(graph, distances, processedNodes, source);
        while (!processedNodes.isEmpty()) {
            Node minDistanceNode = extractMin(processedNodes);
            minDistanceNode.getNeighbors().forEach((neighbor, weight) -> {
                relax(minDistanceNode, neighbor, distances, processedNodes);
            });
        }
        return distances;
    }

    private void initialize(WeightedDirectedGraph graph, Map<Node, Integer> distances, Map<Node, Integer> processedNodes, Node source) {
        for (Node node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
            node.setPredecessor(null);
            processedNodes.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        processedNodes.put(source, 0);
    }

    private Node extractMin(Map<Node, Integer> processedNodes) {
        Node res = null;
        for (Node node : processedNodes.keySet()) {
            if (res == null) {
                res = node;
            } else if (processedNodes.get(node) < processedNodes.get(res)) {
                res = node;
            }
        }
        processedNodes.remove(res);
        return res;
    }

    private void relax(Node node, Node neighbor, Map<Node, Integer> distances, Map<Node, Integer> processedNodes) {
        if (distances.get(neighbor) > distances.get(node) + node.getWeight(neighbor)) {
            Integer newDistance = distances.get(node) + node.getWeight(neighbor);
            distances.put(neighbor, newDistance);
            neighbor.setPredecessor(node);
            processedNodes.put(neighbor, newDistance);
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstraObj = new Dijkstra();
        WeightedDirectedGraph graph = WeightedGraphFactory.getGraph();
        Node source = graph.getNodes()[0];
        Map<Node, Integer> shortestPaths = dijkstraObj.shortestPath(graph, source);
        System.out.println(shortestPaths);
        shortestPaths.forEach((node, distance) -> {
            System.out.println("Distance from " + source + " to " + node + " is " + distance);
            LinkedList<Node> path = new LinkedList<>();
            path.addFirst(node);
            while (node.getPredecessor() != null) {
                path.addFirst(node.getPredecessor());
                node = node.getPredecessor();
            }
            System.out.println("The path is: " + path);
        });
    }

}
