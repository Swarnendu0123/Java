import java.util.*;

import javax.lang.model.type.ErrorType;

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

    // function to print level order tree
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

    // info2rmation class
    static class info2 {
        int dia;
        int height;

        info2(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    // function to calculate dia
    // approch 2 (Efficient in time)
    public static info2 diameter2(Node root) {
        // base case
        if (root == null) {
            return new info2(0, 0);
        }
        // recurtion step
        info2 leftinfo2 = diameter2(root.left);
        info2 rightinfo2 = diameter2(root.right);

        int height = Math.max(leftinfo2.height, rightinfo2.height) + 1;
        int dia = Math.max(Math.max(leftinfo2.dia, rightinfo2.dia), leftinfo2.height + rightinfo2.height + 1);
        return (new info2(dia, height));
    }

    // helping function for is subtree
    public static boolean isIdentical(Node root, Node subRoot) {
        // base case
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

    // function to check subtree is exist in a tree or not
    public static boolean isSubtree(Node root, Node subRoot) {
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

    static class info {
        Node root;
        int HorDist;

        info(Node root, int HorDist) {
            this.HorDist = HorDist;
            this.root = root;
        }
    }

    // function to print top view of a tree
    public static void topView(Node root) {
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int max = 0;
        int min = 0;
        q.add(new info(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.HorDist)) {
                    map.put(curr.HorDist, curr.root);
                }
                if (curr.root.left != null) {
                    q.add(new info(curr.root.left, curr.HorDist - 1));
                    min = Math.min(min, curr.HorDist - 1);
                }
                if (curr.root.right != null) {
                    q.add(new info(curr.root.right, curr.HorDist + 1));
                    max = Math.max(max, curr.HorDist + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    // function to calculate lowest common Ancestor(2nd approch)
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);
        if (rightlca == null) {
            return leftlca;
        }
        if (leftlca == null) {
            return rightlca;
        }
        return root;
    }

    // helping function
    public static int lcadist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = lcadist(root.left, n);
        int rightDist = lcadist(root.right, n);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    // function to calculate min distance b/w two nodes
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcadist(lca, n1);
        int dist2 = lcadist(lca, n2);
        return dist1 + dist2;
    }

    // function to find node
    public static Node findNode(Node root, int n) {
        if (root.data == n || root == null) {
            return root;
        }
        Node ln = findNode(root.left, n);
        Node rn = findNode(root.right, n);
        if (ln == null) {
            return rn;
        } else {
            return ln;
        }
    }

    // Kth ancestor of a node
    // 1
    // / \
    // 2 3
    // /\ /\
    // 4 5 6 7
    public static int KthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    // sum tree (my approch)
    public static int sumTree(Node root) {
        if (root == null) {
            return -1;
        }
        int l = sumTree(root.left);
        int r = sumTree(root.right);
        int data = root.data;
        if (l == -1 && r == -1) {
            data = root.data;
            root.data = 0;
            return data;
        }
        root.data = l + r + root.left.data + root.right.data;
        return data;
    }

    // sum tree (shraddha didi's approch)
    public static int sumTree2(Node root) {
        if (root == null) {
            return 0;
        }
        int l = sumTree2(root.left);
        int r = sumTree2(root.right);
        int data = root.data;
        root.data = l + r;
        return data + l + r;
    }

    public static void main(String[] args) {
        // main tree
        // 1
        // / \
        // 2 3
        // /\ /\
        // 4 5 6 7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // sub tree
        // 2
        // / \
        // 4 5
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        levelOrder(root);
        sumTree(root);
        // 27
        // 9 13
        // 0 0 0 0
        levelOrder(root);
    }
}