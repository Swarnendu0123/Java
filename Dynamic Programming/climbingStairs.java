import java.util.Arrays;

public class climbingStairs {

    // tabulation
    // a person can take 3 steps at atime and he have to climb n stairs at a time =>
    // 1 step, 2 step, 3step find the number of ways to cimb n stairs
    public static int ways(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    // memoization
    // a person can take 3 steps => 1 step, 2 step, 3step
    public static int ways(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return n + 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = ways(n - 1, dp) + ways(n - 2, dp) + ways(n - 3, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(ways(n, dp));
    }
}