import java.util.*;

public class queueReversal {
    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            s.push(q.remove());
        }
        for (int i = 0; i < size; i++) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            q.add(in.nextInt());
        }
        reverse(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
