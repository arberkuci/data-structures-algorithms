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

}
