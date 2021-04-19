package algos.graphs;

import java.util.Map;

import static algos.graphs.GraphFactory.getGraph;

public class App {

    public static void main(String[] args) {
        Graph graph = getGraph();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.bfs(graph.getNodes()[2]);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfs(graph);
        TopologicalSort topologicalSort = new TopologicalSort();
        System.out.println(topologicalSort.topologicalSort(graph));
        TimestampedDFS timestampedDFS = new TimestampedDFS();
        Map<Node, Integer[]> res = timestampedDFS.dfs(graph);
        res.forEach((node, integers) -> {
            System.out.print("Node: " + node + " -> Discovered: " + integers[0] + " , Finished its neighbors: " + integers[1]);
            System.out.println();
        });
    }

}
