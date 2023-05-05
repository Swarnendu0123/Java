import java.util.*;

public class perfectNumber {

    public static boolean check(int n, int i, int ans) {
        if (i == n - 1) {
            if (ans == n) {
                return true;
            } else {
                return false;
            }
        }
        if (n % i == 0) {
            ans = ans + i;
        }
        return check(n, i + 1, ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(check(n, 2, 1));
    }
}
