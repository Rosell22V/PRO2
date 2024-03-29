package exc02;

import java.util.*;

/**
 * BinaryTree models a binary tree.
 */
public class binaryTree<E> {
    private Node root;

    /**
     * Create an empty binary tree.
     */
    public binaryTree() {
        root = null;
    }

    /**
     * Create a binary tree with one node.
     */
    public binaryTree(E rootData) {
        root = new Node(rootData);
    }

    /**
     * Create a BinaryTree with a root node, and
     * 'left' as left subtree and 'right' as right subtree.
     * Pre: 'left' != 'right'.
     * Note: 'left' and 'right' are nullable.
     */
    public binaryTree(E rootData, binaryTree<E> left, binaryTree<E> right) {
        root = new Node(rootData);
        if (left != null) {
            root.left = left.root;
        }
        if (right != null) {
            root.right = right.root;
        }
    }

    //-------------------------------------------------------------------------

    /**
     * Return true if this tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    public int getHeight(){
        return heightHelper(root);
    }

    private int heightHelper(Node root){
        if(root == null){
            return 0;
        }
        int leftSub = heightHelper(root.left);
        int rightSub = heightHelper(root.right);
        return Math.max(leftSub, rightSub) + 1;
    }

    public int getSize(){
        return sizeHelper(root);
    }

    private int sizeHelper(Node root){
        if(root != null){
            int left = sizeHelper(root.left);
            int right = sizeHelper(root.right);
            return left + right + 1;
        }
        return 0;
    }

    public int getLeafCount(){
        return leafHelper(root);
    }

    private int leafHelper(Node root){
        if(root.left != null && root.right != null){
            int left = leafHelper(root.left);
            int right = leafHelper(root.right);
            return left + right;
        }
        return 1;
    }

    /**
     * Return the data at the root of this tree.
     * Pre: The tree is not empty.
     */
    public E rootData() {
        return root.data;
    }

    /**
     * Return a reference to the left subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public binaryTree<E> left() {
        if(root.left == null){
            return null;
        }
        binaryTree<E> leftTree = new binaryTree<>();
        leftTree.root = root.left;
        return leftTree;
    }

    /**
     * Return a reference to the right subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public binaryTree<E> right() {
        if(root.right == null){
            return null;
        }
        binaryTree<E> rightTree = new binaryTree<>();
        rightTree.root = root.right;
        return rightTree;
    }

    public void printPreorder(){
        printPreorderHelper(root);
    }

    private void printPreorderHelper(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            printPreorderHelper(root.left);
            printPreorderHelper(root.right);
        }
    }

    public void printInorder(){
        printInorderHelper(root);
    }

    private void printInorderHelper(Node root){
        if(root != null){
            printInorderHelper(root.left);
            System.out.print(root.data + " ");
            printInorderHelper(root.right);
        }
    }

    public List<E> listInorder(){
        List<E> list = new ArrayList<>();
        listInorderHelper(root, list);
        return list;
    }

    private void listInorderHelper(Node root, List<E> list){
        if(root != null){
            listInorderHelper(root.left, list);
            list.add(root.data);
            listInorderHelper(root.right, list);
        }
    }

    public void printPostorder(){
        printPostorderHelper(root);
    }

    private void printPostorderHelper(Node root){
        if(root != null){
            printPostorderHelper(root.left);
            printPostorderHelper(root.right);
            System.out.print(root.data + " ");
        }
    }
////
//    public void printLevelOrder() {
//        if (root == null) {
//            return;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            Node popped = queue.poll();
//            System.out.print(popped.data + " ");
//
//            if (popped.left != null) {
//                queue.add(popped.left);
//            }
//
//            if (popped.right != null) {
//                queue.add(popped.right);
//            }
//        }
//    }
//
//
//    /*
//    Private helpermethod for recursively calling printLevelOrder
//     */
//    private void printGivenLevel(Node n, int level){
//        if (n == null){
//            return;
//        }
//        if (level == 1){
//            System.out.println(n.data);;
//        }
//        else if (level > 1){
//            printGivenLevel(n.left,level-1);
//            printGivenLevel(n.right,level-1);
//        }
//    }
//
//    /* Public method for printing the level order
////     */
//
//    public void printLevelOrder(){
//        int h = height(root);
//        for (int i = 0; i <= h; i++) {
//            printGivenLevel(root,i);
//        }
//    }

    //-------------------------------------------------------------------------

    private class Node {
        private E data;
        private Node left;
        private Node right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}