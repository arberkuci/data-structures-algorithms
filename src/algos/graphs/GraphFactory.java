package algos.graphs;

public class GraphFactory {

    public static Graph getGraph() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.setNeighbors(new Node[]{two, four});
        two.setNeighbors(new Node[]{five, three});
        four.setNeighbors(new Node[]{two});
        three.setNeighbors(new Node[]{five, six});
        six.setNeighbors(new Node[]{five});

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.bfs(three);
        return new Graph(new Node[]{one, two, three, four, five, six});
    }

}
