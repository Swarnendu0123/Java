import java.util.*;
import java.math.BigInteger;
import java.math.*;;

public class test {

    public static void check(int x) {
        if (x == 2) {
            System.out.println(1 + " " + 1 + " " + 1);
            return;
        }
        double n = (int) Math.sqrt(x);
        if (n % 1 != 0) {
            int m = (int) n;
            System.out.println(m + " " + m + " " + (x - (m * m)));
            return;
        }
        int j;
        int maxA = 0;
        int maxB = 0;
        int maxC = Integer.MIN_VALUE;
        for (j = 1; j <= x; j++) {
            int a = j;
            int b = (x - (x % a)) / a;
            int c = x % a;
            if (a * b + c == x) {
                if (c == 0) {
                    continue;
                }
                if (c > maxC) {
                    maxA = a;
                    maxB = b;
                    maxC = c;
                }
            }
        }
        if (maxA * maxB + maxC == x) {
            System.out.println(maxA + " " + maxB + " " + maxC);
            return;
        }
        System.out.println(-1);
    }

    public static void check2(int x) {
        double n = (int) Math.sqrt(x);

        int m = (int) n;
        if (n % 1 != 0) {
            System.out.println(m + " " + m + " " + (x - (m * m)));
            return;
        }
        System.out.println((m - 1) + " "+(m-1)+" "+(x-(m-1)*(m-1)));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            check2(x);
        }
    }
}
