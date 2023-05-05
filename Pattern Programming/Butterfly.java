import java.util.Scanner;

public class Butterfly {
    public static void main(String[] augs) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n - 1; i > -1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}