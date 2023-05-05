import java.util.*;

public class stackQuestions {

    // question form amazon
    // push the data at the back
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

    // function to reverse string
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            sb.append(curr);
        }
        return sb.toString();
    }

    // function to reverse stack - recursive approch
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int temp = s.pop();
        reverseStack(s);
        pushAtBottom(s, temp);
    }

    // stock span problem
    public static void stcokSpan(int data[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < data.length; i++) {
            int currPrice = data[i];
            while (!(s.isEmpty()) && currPrice >= data[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    // function to next greater element
    public static void nextGreaterELement(int data[], int next[]) {
        Stack<Integer> s = new Stack<>();
        next[next.length - 1] = -1;
        for (int i = data.length - 1; i >= 0; i--) {
            int curr = data[i];
            while (!s.isEmpty() && data[s.peek()] <= curr) {
                s.pop();
            }
            if (s.isEmpty()) {
                next[i] = -1;
            } else {
                next[i] = data[s.peek()];
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int data[] = new int[in.nextInt()];
        int span[] = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = in.nextInt();
        }
        stcokSpan(data, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
