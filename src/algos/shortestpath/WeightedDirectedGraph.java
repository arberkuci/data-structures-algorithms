package algos.shortestpath;

import java.util.HashMap;
import java.util.Map;

public class WeightedDirectedGraph {

    private Node[] nodes;

    public WeightedDirectedGraph(Node[] nodes) {
        this.nodes = nodes;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

}
