package algos.shortestpath;

import java.util.*;

public class DagShortestPaths {

    public Map<Node, Integer> dagShortestPath(WeightedDirectedGraph weightedDirectedGraph, Node source) {
        LinkedList<Node> topologicalSortedNodes = this.topologicalSort(weightedDirectedGraph);
        Map<Node, Integer> distance = new HashMap<>();
        initialize(distance, topologicalSortedNodes, source);
        Iterator<Node> iterator = topologicalSortedNodes.iterator();
        boolean foundSource = false;
        while (iterator.hasNext()) {
            Node currentNode = iterator.next();
            if (!foundSource && currentNode != source) {
                continue;
            } else {
                foundSource = true;
                currentNode.getNeighbors().forEach((neighbor, weight) -> {
                    relax(currentNode, neighbor, distance);
                });
            }
        }
        return distance;
    }



    private void initialize(Map<Node, Integer> distance, LinkedList<Node> topologicalSortedNodes, Node source) {
        for (Node node : topologicalSortedNodes) {
            distance.put(node, Integer.MAX_VALUE);
            node.setPredecessor(null);
        }
        distance.put(source, 0);
    }


    private void relax(Node node, Node neighbor, Map<Node, Integer> distance) {
        if (distance.get(neighbor) > distance.get(node) + node.getWeight(neighbor)) {
            distance.put(neighbor, distance.get(node) + node.getWeight(neighbor));
            neighbor.setPredecessor(node);
        }
    }

    private LinkedList<Node> topologicalSort(WeightedDirectedGraph graph) {
        Set<Node> visited = new HashSet<>();
        LinkedList<Node> sortedNodes = new LinkedList<>();// Topologically sorted nodes.
        depthFirstSearch(graph, visited, sortedNodes);
        return sortedNodes;
    }

    private void depthFirstSearch(WeightedDirectedGraph graph, Set<Node> visited, LinkedList<Node> sortedNodes) {
        for (Node node : graph.getNodes()) {
            if (!visited.contains(node)) {
                visited.add(node);
                depthFirstSearchVisit(node, visited, sortedNodes);
            }
        }
    }

    private void depthFirstSearchVisit(Node node, Set<Node> visited, LinkedList<Node> sortedNodes) {
        node.getNeighbors().forEach((neighbor, weight) -> {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                depthFirstSearchVisit(neighbor, visited, sortedNodes);
            }
        });
        sortedNodes.addFirst(node);
    }

    public static void main(String[] args) {
        WeightedDirectedGraph graph = WeightedGraphFactory.getDAG();
        DagShortestPaths dagShortestPaths = new DagShortestPaths();
        Map<Node, Integer> res = dagShortestPaths.dagShortestPath(graph, graph.getNodes()[1]);
        System.out.println(res);
        res.forEach((node, distance) -> {
            System.out.println("The predecessor of node: " + node + " is: " + node.getPredecessor());
        });
    }

}
