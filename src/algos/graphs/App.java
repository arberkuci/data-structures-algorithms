package algos.graphs;

public class App {


    public static void main(String[] args) {
        BreadthFirstSearch.Node one = new BreadthFirstSearch.Node(1);
        BreadthFirstSearch.Node two = new BreadthFirstSearch.Node(2);
        BreadthFirstSearch.Node three = new BreadthFirstSearch.Node(3);
        BreadthFirstSearch.Node four = new BreadthFirstSearch.Node(4);
        BreadthFirstSearch.Node five = new BreadthFirstSearch.Node(5);
        BreadthFirstSearch.Node six = new BreadthFirstSearch.Node(6);

        one.setNeighbors(new BreadthFirstSearch.Node[]{two, four});
        two.setNeighbors(new BreadthFirstSearch.Node[]{five});
        five.setNeighbors(new BreadthFirstSearch.Node[]{four});
        four.setNeighbors(new BreadthFirstSearch.Node[]{two});
        three.setNeighbors(new BreadthFirstSearch.Node[]{five, six});
        six.setNeighbors(new BreadthFirstSearch.Node[]{six});

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.bfs(three);
    }

}
