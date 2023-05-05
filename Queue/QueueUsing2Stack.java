import java.util.*;

public class QueueUsing2Stack {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // function to check queue is empty or not
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add Time complexity = O(n)
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove Time complexity = O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty");
                return Integer.MIN_VALUE;
            }
            return s1.pop();
        }

        // peek Time complexity = O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty");
                return Integer.MIN_VALUE;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
