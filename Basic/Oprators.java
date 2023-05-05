import java.util.*;

public class Oprators {
    public static void main(String[] augs) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        // sum
        System.out.println("sum :" + (num1 + num2));
        // difference
        System.out.println("difference :" + (num1 - num2));
        // mul
        System.out.println("mul :" + (num1 * num2));
        // div
        System.out.println("div :" + (num1 / num2));
        // mudulo oprator
        System.out.println("remainder(num1%num2) :" + (num1 % num2));
        System.out.println("remainder(num2%num1) :" + (num2 % num1));
    }
}