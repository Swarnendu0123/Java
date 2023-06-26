import java.util.*;

public class Knapscak {

    // 0-1 knapsack
    // recursive approch
    public static int knapsack(int[] value, int[] wt, int n, int W) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {// we can include
            // include
            int ans1 = knapsack(value, wt, n - 1, W - wt[n - 1]) + value[n - 1];
            // exclude
            int ans2 = knapsack(value, wt, n - 1, W);
            return Math.max(ans1, ans2);
        } else {
            // exclude
            return knapsack(value, wt, n - 1, W);
        }
    }

    // 0-1 knapscak
    // memoization approch
    public static int knapsackMemo(int[] value, int[] wt, int n, int W, int[][] dp) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {// already calculated
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {// we can include
            // include
            int ans1 = knapsack(value, wt, n - 1, W - wt[n - 1]) + value[n - 1];
            // exclude
            int ans2 = knapsack(value, wt, n - 1, W);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            // exclude
            dp[n][W] = knapsack(value, wt, n - 1, W);
            return dp[n][W];
        }
    }

    // 0-1 knapsack
    // tabulation
    public static int knapsackTab(int[] value, int[] wt, int n, int W) {
        // initialization
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= wt[i - 1]) {// we can include
                    // include
                    int ans1 = dp[i - 1][j - wt[i - 1]] + value[i - 1];
                    // exclude
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] value = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;

        int ans = knapsack(value, wt, wt.length, 7);
        System.out.println(ans);
    }
}
