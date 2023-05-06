import java.util.*;

public class minAbsoluteDifference {
    public static void main(String[] args) {
        int A[] = { 1, 2, 3 };
        int B[] = { 2, 1, 3 };
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < B.length; i++) {
            int diff = A[i] - B[i];
            sum += ((diff > 0) ? diff : -diff);
        }
        System.out.println(sum);
    }
}
