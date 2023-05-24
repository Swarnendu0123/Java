import java.util.*;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // function for in order printing
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // insert function
    public static Node insert(int key, Node root) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (root.data > key) {
            // inserting in lest subtree
            root.left = insert(key, root.left);
        } else {
            // inserting in right subtree
            root.right = insert(key, root.right);
        }
        return root;
    }

    // build tree
    public static Node buildTree(Node root, int[] data) {
        for (int i = 0; i < data.length; i++) {
            int key = data[i];
            root = insert(key, root);
        }
        return root;
    }

    //function for search in a BST
    public static boolean search(int key, Node root) {
        if (root == null) {
            return false;
        } else if (root.data == key) {
            return true;
        } else if (root.data > key) {
            return search(key, root.left);
        } else {
            return search(key, root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int data[] = { 5, 1, 3, 4, 2, 7 };
        root = buildTree(root, data);
        inOrder(root);
        System.out.println(search(10, root));
    }
}