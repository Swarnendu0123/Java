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

    // function for search in a BST
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

    // function to find in order successor
    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // function to delete a node
    public static Node delete(Node root, int data) {
        if (root.data > data) {
            root.left = delete(root.left, data);
        } else if (root.data < data) {
            root.right = delete(root.right, data);
        } else {
            // case 1
            if (root.right == null && root.left == null) {
                return null;
            }
            // case 2
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }
            // case 3
            Node Is = inOrderSuccessor(root.right);// finding in order successor
            root.data = Is.data;
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // function to print in range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (k1 <= root.data && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data >= k2) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    // function to print root to leaf paths
    public static void root2leaf(Node root, ArrayList<Integer> path) {
        // base case
        if (root == null) {
            return;
        }
        path.add(root.data);
        // printing case
        if (root.left == null && root.right == null) {
            System.out.println(path);
        }
        root2leaf(root.left, path);
        root2leaf(root.right, path);
        path.remove(path.size() - 1);
        return;
    }

    public static void main(String[] args) {
        Node root = null;
        int data[] = { 8, 5, 3, 6, 10, 11, 14 };
        root = buildTree(root, data);
        inOrder(root);
        System.out.println();
        root2leaf(root, new ArrayList<>());
    }
}