package algos.graphs;

class Node {

    private Node[] neighbors;
    private int value;

    public Node() {

    }

    public Node(int value) {
        this.value = value;
    }

    public Node(Node[] neighbors) {
        this.neighbors = neighbors;
    }

    public Node[] getNeighbors() {
        return neighbors == null ? new Node[]{} : neighbors;
    }

    public int getValue() {
        return value;
    }

    public void setNeighbors(Node[] neighbors) {
        this.neighbors = neighbors;
    }
}