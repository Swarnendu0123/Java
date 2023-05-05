import java.util.*;

public class firstNonRepeatingLetter {

    public static void printNonRepeating(String str) {
        int data[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            data[ch - 'a']++;
            while ((!q.isEmpty()) && data[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        printNonRepeating(str);
    }
}
