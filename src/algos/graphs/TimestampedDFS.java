package algos.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * A version of DFS where we keep track of discovery of a node.
 * Also, we keep track of finishing the processing of the neighbors of a node.
 */
public class TimestampedDFS {

    private Integer timestamp = 0;

    public Map<Node, Integer[]> dfs(Graph graph) {
        Set<Node> visited = new HashSet<>();
        Map<Node, Integer[]> timestamps = new HashMap<>();
        for (Node node : graph.getNodes()) {
            if (!visited.contains(node)) {
                visited.add(node);
                dfsVisit(node, visited, timestamps);
            }
        }
        return timestamps;
    }

    private void dfsVisit(Node node, Set<Node> visited, Map<Node, Integer[]> timestamps) {
        timestamp++;
        Integer[] ts = new Integer[2];
        ts[0] = timestamp;//discovery time
        for (Node adjacent : node.getNeighbors()) {
            if (!visited.contains(adjacent)) {
                visited.add(adjacent);
                dfsVisit(adjacent, visited, timestamps);
            }
        }
        timestamp++;
        ts[1] = timestamp;//timestamp when processing neighbors of a node is done.
        timestamps.put(node, ts);
    }

}
