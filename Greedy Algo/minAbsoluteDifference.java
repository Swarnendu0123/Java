import java.util.*;

public class minAbsoluteDifference {
    public static void main(String[] args) {
        int A[] = { 4, 1, 8, 7 };
        int B[] = { 2, 3, 6, 5 };
        int sum = 0;
        Arrays.sort(A);// Time=O(nlogn)
        Arrays.sort(B);// Time=O(nlogn)
        for (int i = 0; i < B.length; i++) {
            int diff = A[i] - B[i];
            sum += ((diff > 0) ? diff : -diff);
        }
        System.out.println("min abs diff of pairs = " + sum);
    }
}
