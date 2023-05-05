import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.BigInteger;

public class Swap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int data[] = new int[in.nextInt()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            data[i] = in.nextInt();
            max = Math.max(max, data[i]);
        }
        int data2[] = new int[max + 1];
        for (int i = 0; i < data.length; i++) {
            data2[data[i]]++;
        }
        for (int i = 0; i < data2.length; i++) {
            System.out.print(data2[i] + " ");
        }
    }
}