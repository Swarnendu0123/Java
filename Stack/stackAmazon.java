import java.util.*;

public class stackAmazon {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        // base case
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        // recurtion step
        int temp = s.pop();
        pushAtBottom(s, data);
        s.push(temp);
    }

    // function to print stack
    public static void print(Stack<Integer> s) {
        System.out.println(s.toString());
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        print(s);
        s.push(3);
        print(s);
        pushAtBottom(s, 4);
        print(s);
    }
}
