package algos.bst;

public class App {

    public static void main(String[] args) {
        BinarySearchTree.Node node15 = new BinarySearchTree.Node(15);
        BinarySearchTree.Node node6 = new BinarySearchTree.Node(6);
        BinarySearchTree.Node node18 = new BinarySearchTree.Node(18);
        BinarySearchTree.Node node3 = new BinarySearchTree.Node(3);
        BinarySearchTree.Node node7 = new BinarySearchTree.Node(7);
        BinarySearchTree.Node node17 = new BinarySearchTree.Node(17);
        BinarySearchTree.Node node20 = new BinarySearchTree.Node(20);
        BinarySearchTree.Node node2 = new BinarySearchTree.Node(2);
        BinarySearchTree.Node node4 = new BinarySearchTree.Node(4);
        BinarySearchTree.Node node13 = new BinarySearchTree.Node(13);
        BinarySearchTree.Node node9 = new BinarySearchTree.Node(9);
        BinarySearchTree.Node node14 = new BinarySearchTree.Node(14);
        BinarySearchTree.Node node5 = new BinarySearchTree.Node(5);
        node15.left = node6;
        node6.parent = node15;
        node15.right = node18;
        node18.parent = node15;
        node6.left = node3;
        node3.parent = node6;
        node6.right = node7;
        node7.parent = node6;
        node18.left = node17;
        node17.parent = node18;
        node18.right = node20;
        node20.parent = node18;
        node3.left = node2;
        node3.right = node4;
        node7.right = node13;
        node13.parent = node7;
        node13.left = node9;
        node9.parent = node13;
        node13.right = node14;
        node14.parent = node13;
        node4.right = node5;
        node5.parent = node4;
        BinarySearchTree bst = new BinarySearchTree();
        bst.inOrderWalk(node15);
        System.out.println();
        System.out.println(bst.search(node15, 13).value);
        System.out.println();
        System.out.println(bst.searchIterative(node15, 13).value);
        System.out.println();
        System.out.println(bst.minimum(node15).value);
        System.out.println();
        System.out.println(bst.minimumIterative(node15).value);
        System.out.println();
        System.out.println(bst.maximum(node15).value);
        System.out.println();
        System.out.println(bst.maximumIterative(node15).value);
        System.out.println();
        System.out.println(bst.successor(node13).value);
        System.out.println(bst.successor(node14).value);
    }

}
