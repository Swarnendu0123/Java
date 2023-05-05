import java.util.*;

public class StackDataStr {

    // stack using Array List
    static class StackAL {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // stack using Linked List
    static class StackLL {
        static Node head = null;

        public boolean isEmpty() {
            return head == null;
        }

        // push -> add
        public void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop -> remove
        public int pop() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek -> see
        public int peek() {
            if (isEmpty()) {
                return -Integer.MIN_VALUE;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        // StackLL s = new StackLL();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
