import java.util.*;

public class statckUsingDeque {
    static class Stack {
        static Deque<Integer> dq = new LinkedList<>();

        public void push(int data) {
            dq.addLast(data);
        }

        public int pop() {
            return dq.removeLast();
        }

        public static int peek() {
            return dq.getLast();
        }

        public boolean isEmpty() {
            return dq.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
