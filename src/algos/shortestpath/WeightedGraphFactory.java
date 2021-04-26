package algos.shortestpath;

public class WeightedGraphFactory {

    public static WeightedDirectedGraph getDAG() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.addNeighbor(node2, 5);
        node1.addNeighbor(node3, 3);
        node2.addNeighbor(node4, 6);
        node2.addNeighbor(node3, 2);
        node3.addNeighbor(node4, 7);
        node3.addNeighbor(node6, 2);
        node4.addNeighbor(node5, -1);
        node4.addNeighbor(node6, 1);
        node5.addNeighbor(node6, -2);

        WeightedDirectedGraph graph = new WeightedDirectedGraph(new Node[]{node1, node2, node3, node4, node5, node6});
        return graph;
    }

    public static WeightedDirectedGraph getGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.addNeighbor(node2, 10);
        node1.addNeighbor(node3, 5);

        node2.addNeighbor(node3, 2);
        node2.addNeighbor(node4, 1);

        node3.addNeighbor(node4, 9);
        node3.addNeighbor(node5, 2);
        node3.addNeighbor(node2, 3);

        node4.addNeighbor(node5, 4);

        node5.addNeighbor(node1, 7);
        node5.addNeighbor(node4, 6);

        return new WeightedDirectedGraph(new Node[]{node1, node2, node3, node4, node5});
    }


    public static WeightedDirectedGraph getGraphWithNegativeWeights() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.addNeighbor(node2, 6);
        node1.addNeighbor(node3, 7);

        node2.addNeighbor(node4, 5);
        node2.addNeighbor(node5, -4);
        node2.addNeighbor(node3, 8);

        node3.addNeighbor(node4, -3);
        node3.addNeighbor(node5, 9);

        node4.addNeighbor(node2, -2);

        node5.addNeighbor(node4, 7);
        node5.addNeighbor(node1, 2);

        return new WeightedDirectedGraph(new Node[]{node1, node2, node3, node4, node5});
    }

}
