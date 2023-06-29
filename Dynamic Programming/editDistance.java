import java.util.*;

public class editDistance {
    // recursion
    public static int editDist(int m, int n, String s1, String s2) {
        // base case
        if (m == 0 || n == 0) {
            return Math.max(m, n);
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDist(m - 1, n - 1, s1, s2);
        } else {
            // add
            int ans1 = editDist(m - 1, n, s1, s2);
            // remove
            int ans2 = editDist(m, n - 1, s1, s2);
            // replace
            int ans3 = editDist(m - 1, n - 1, s1, s2);
            return Math.min(Math.min(ans2, ans1), ans3) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int m = s1.length();
        int n = s2.length();
        System.out.println(editDist(m, n, s1, s2));
    }
}
