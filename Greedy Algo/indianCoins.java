import java.util.*;

public class indianCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // stack approch
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(5);
        s.push(10);
        s.push(20);
        s.push(50);
        s.push(100);
        s.push(500);
        s.push(2000);
        int v = in.nextInt();
        ArrayList<Integer> notes = new ArrayList<>();
        while (!s.isEmpty() && v > 0) {
            if (s.peek() <= v) {
                v -= s.peek();
                notes.add(s.peek());
            } else {
                s.pop();
            }
        }
        System.out.println("Minimum numbers Notes = " + notes.size());
        System.out.println(notes);
    }
}