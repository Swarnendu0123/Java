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

    // function to calculate max value of a tree
    public static int maxVal(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maxVal(root.left), maxVal(root.right)));
    }

    // function to calculate min value of a tree
    public static int minVal(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minVal(root.left), minVal(root.right)));
    }

    // function for valid BST (my Approch)
    public static boolean validBST(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.right != null) {
            int rightmin = minVal(root.right);
            if (root.data > rightmin) {
                return false;
            }
        }
        if (root.left != null) {
            int leftmax = maxVal(root.left);
            if (root.data < leftmax) {
                return false;
            }
        }
        if ((!validBST(root.left)) || (!validBST(root.right))) {
            return false;
        }
        return true;
    }

    // function for vaid BST (Shraddha didi's approch)
    public static boolean validBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.data >= root.data) {
            return false;
        }
        if (max != null && max.data <= root.data) {
            return false;
        }
        if (!validBST(root.left, min, root)) {
            return false;
        }
        if (!validBST(root.right, root, max)) {
            return false;
        }
        return true;
    }

    // function to mirror a BST
    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null;
        }
        Node lefts = mirrorBST(root.left);
        Node rights = mirrorBST(root.right);
        root.left = rights;
        root.right = lefts;
        return root;
    }

    // function to calcuate balenced BST
    public static Node balencedBST(ArrayList<Integer> data, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(data.get(mid));
        root.left = balencedBST(data, start, mid - 1);
        root.right = balencedBST(data, mid + 1, end);
        return root;
    }

    // function to get Inorder seq
    public static void inOrderSeq(Node root, ArrayList<Integer> seq) {
        if (root == null) {
            return;
        }
        inOrderSeq(root.left, seq);
        seq.add(root.data);
        inOrderSeq(root.right, seq);
    }

    // function to create balanced BST form a unbalanced BST
    public static Node ubBSTbBST(Node root) {
        ArrayList<Integer> seq = new ArrayList<>();
        inOrderSeq(root, seq);
        root = balencedBST(seq, 0, seq.size() - 1);
        return root;
    }

    // information class
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if ((!leftInfo.isBST) || (!rightInfo.isBST)) {
            return new Info(false, size, min, max);
        }
        maxBST = Math.max(maxBST, size);
        return new Info(true, size, min, max);
    }

    // function to merge two BST
    public static Node merge2BSt(Node root1, Node root2) {
        ArrayList<Integer> seq1 = new ArrayList<>();
        ArrayList<Integer> seq2 = new ArrayList<>();
        ArrayList<Integer> mergedSeq = new ArrayList<>();

        inOrderSeq(root1, seq1);
        inOrderSeq(root2, seq2);
        int i = 0;
        int j = 0;
        while ((i < seq1.size()) && (j < seq2.size())) {
            if (seq1.get(i) <= seq2.get(j)) {
                mergedSeq.add(seq1.get(i));
                i++;
            } else {
                mergedSeq.add(seq2.get(j));
                j++;
            }
        }
        while (i < seq1.size()) {
            mergedSeq.add(seq1.get(i));
            i++;
        }
        while (j < seq2.size()) {
            mergedSeq.add(seq2.get(j));
            j++;
        }
        return balencedBST(mergedSeq, 0, i + j - 1);
    }

    public static void main(String[] args) {
        // int data[] = { 8, 5, 3, 6, 10, 11, 14 };
        // int data[] = { 8, 5, 3, 6, 10, 11 };
        // int data[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        /// test tree
        // 50
        // / \
        // 30 60
        // / \ / \
        // 5 20 45 70
        //         / \
        //        65 80

        // test tree 1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // test tree 2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        inOrder(root1);
        System.out.println();
        inOrder(root2);
        System.out.println();
        root = merge2BSt(root1, root2);
        inOrder(root);
        System.out.println();
        System.out.println(root.right.data);
    }
}