package algos.bst;

public class BinarySearchTree {

    public void inOrderWalk(Node root) {
        if (root != null) {
            inOrderWalk(root.left);
            System.out.println(root.value);
            inOrderWalk(root.right);
        }
    }

    public Node search(Node root, int key) {
        if (root == null || key == root.value) return root;
        if (key < root.value) return search(root.left, key);
        else return search(root.right, key);
    }

    public Node searchIterative(Node root, int key) {
        while (root != null && key != root.value) {
            if (key < root.value) root = root.left;
            else root = root.right;
        }
        return root;
    }

    public Node minimum(Node root) {
        if (root.left != null) return minimum(root.left);
        return root;
    }

    public Node minimumIterative(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public Node maximum(Node root) {
        if (root.right != null) return maximum(root.right);
        return root;
    }

    public Node maximumIterative(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public Node successor(Node node) {
        if (node == null) return null;
        if (node.right != null) return minimumIterative(node.right);
        Node parent = node.parent;
        while (parent != null
                && parent.right != null
                && parent.right.value == node.value) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public void insert(Node root, int value) {
        Node parent = null;
        while (root != null) {
            parent = root;
            if (value < root.value) root = root.left;
            else root = root.right;
        }
        Node newNode = new Node(value);
        newNode.parent = parent;
        if (parent == null) root = newNode;
        else if (value < parent.value) parent.left = newNode;
        else parent.right = newNode;
    }

    public void delete(Node root, Node node) {
        if (node.left == null) {
            transplant(root, node, node.right);
        } else if (node.right == null) {
            transplant(root, node, node.left);
        } else {
            Node successor = minimumIterative(node.right);
            if (successor.parent != node) {
                transplant(root, successor, successor.right);
                successor.right = node.right;
                successor.right.parent = successor;
            }
            transplant(root, node, successor);
            successor.left = node.left;
            successor.left.parent = successor;
        }
    }

    private void transplant(Node root, Node node1, Node node2) {
        boolean isRoot = node1.parent == null;
        if (isRoot) root = node2;
        else if (isLeftChild(node1))
            node1.parent.left = node2;
        else
            node1.parent.right = node2;
        if (node2 != null) node1.parent = node2.parent;
    }

    private boolean isLeftChild(Node node) {
        return node.parent != null
                && node.parent.left == node;
    }

    private boolean isRightChild(Node node) {
        return node.parent != null
                && node.parent.right == node;
    }

    static class Node {

        public Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;
        Node parent;
    }

}
