package algos.shortestpath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BellmanFord {

    public Map<Node, Integer> shortestPath(WeightedDirectedGraph graph, Node source) throws Exception {
        Map<Node, Integer> distances = new HashMap<>();
        initialize(graph, source, distances);
        int noNodes = graph.getNodes().length;
        for (int i = 1; i < noNodes; i++) {
            for (Node node : graph.getNodes()) {
                node.getNeighbors().forEach((neighbor, weight) -> {
                    relax(node, neighbor, distances);
                });
            }
        }
        for (Node node : graph.getNodes()) {
            for (Node neighbor : node.getNeighbors().keySet()) {
                if (distances.get(neighbor) > distances.get(node) + node.getWeight(neighbor)) {
                    throw new Exception("Graph has path that are cyclic and have negative weight!");
                }
            }
        }
        return distances;
    }

    private void initialize(WeightedDirectedGraph graph, Node source, Map<Node, Integer> distances) {
        for (Node node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
            node.setPredecessor(null);
        }
        distances.put(source, 0);
    }

    private void relax(Node node, Node neighbor, Map<Node, Integer> distances) {
        long neighborDistance = distances.get(neighbor);
        long newPathDistance = (long) distances.get(node) + (long) node.getWeight(neighbor);
        if (neighborDistance > newPathDistance) {
            distances.put(neighbor, (int) newPathDistance);
            neighbor.setPredecessor(node);
        }
    }

    public static void main(String[] args) throws Exception {
        BellmanFord bellmanFord = new BellmanFord();
        WeightedDirectedGraph graph = WeightedGraphFactory.getGraphWithNegativeWeights();
        Node source = graph.getNodes()[0];
        Map<Node, Integer> result = bellmanFord.shortestPath(graph, source);
        result.forEach((node, distance) -> {
            System.out.println("The distance from " + source + " to " + node + " is " + distance);
            System.out.println("The path from " + source + " to " + node + " is :");
            LinkedList<Node> predecessors = new LinkedList<>();
            while (node.getPredecessor() != null){
                predecessors.addFirst(node.getPredecessor());
                node = node.getPredecessor();
            }
            System.out.println(predecessors);
            System.out.println();
        });
    }

}
