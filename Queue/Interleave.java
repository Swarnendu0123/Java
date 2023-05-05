import java.util.*;

public class Interleave {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            q.add(in.nextInt());
        }
        int size = q.size();
        Queue<Integer> first = new LinkedList<>();
        for (int i = 0; i < size / 2; i++) {
            first.add(q.remove());
        }
        while (!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
        }
        for (int i = 0; i < size; i++) {
            System.out.print(q.remove() + " ");
        }
    }
}
