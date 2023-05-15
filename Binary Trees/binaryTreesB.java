import java.util.*;

public class binaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }

    static class BineryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // function for pre order printing
    public static void preOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // function for in order printing
    public static void inOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // function for post order printing
    public static void postOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // function to print lveel order tree
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // function to calculate tree height
    public static int height(Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        // recurtion step
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // function to count nodes of a tree
    public static int countNodes(Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        // recurtion step
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // function to calculate the sum of nodes
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    // function to calculate diameter of a tree
    // approch 1
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int ld = diameter(root.left);// left dia
        int rd = diameter(root.right);// right dia
        int lh = height(root.left);// left height
        int rh = height(root.right);// right height
        int maxD = Math.max(ld, rd);
        return Math.max(maxD, lh + rh + 1);
    }

    // information class
    static class info {
        int dia;
        int height;

        info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    // function to calculate dia
    // approch 2 (Efficient in time)
    public static info diameter2(Node root) {
        // base case
        if (root == null) {
            return new info(0, 0);
        }
        // recurtion step
        info leftInfo = diameter2(root.left);
        info rightInfo = diameter2(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.height + rightInfo.height + 1);
        return (new info(dia, height));
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(root.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {

        // base case
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        int[] tree1 = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int[] tree2 = { 2, 4, -1, -1, 5, -1, -1 };
        int[] tree3 = { 1, 2, 4, 9, -1, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1 };
        BineryTree tree = new BineryTree();
        Node root = tree.buildTree(tree3);
        Node subroot = tree.buildTree(tree2);
        System.out.println(isSubtree(root, subroot));
    }
}