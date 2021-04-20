package algos.shortestpath;

import java.util.HashMap;
import java.util.Map;

class Node {

    private Map<Node, Integer> neighbors;// adjacent nodes and weights between them.
    private Node predecessor;
    private int value;

    public Node() {

    }

    public Node(int value) {
        this.value = value;
    }

    public void addNeighbor(Node neighbor, int weight) {
        if (this.neighbors == null) this.neighbors = new HashMap<>();
        this.neighbors.put(neighbor, weight);
    }

    public Integer getWeight(Node neighbor) {
        return this.neighbors.get(neighbor);
    }

    public Node(Map<Node, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public Map<Node, Integer> getNeighbors() {
        return neighbors == null ? new HashMap<Node, Integer>() : neighbors;
    }

    public int getValue() {
        return value;
    }

    public void setNeighbors(HashMap<Node, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

}
