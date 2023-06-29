public class UnboundedKnapsack {
    // unbounded knapsack
    // by recursion
    public static int knapsack(int value[], int wt[], int n, int W) {
        // base case
        if (n == 0 || W == 0) {
            return 0;
        }
        if (W >= wt[n - 1]) {
            int ans1 = knapsack(value, wt, n, W - wt[n - 1]) + value[n - 1];
            int ans2 = knapsack(value, wt, n - 1, W);
            return Math.max(ans1, ans2);
        } else {
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

    public static void main(String[] args) {
        int[] value = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsack(value, wt, value.length, W));
        int[][] dp = new int[value.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackMemo(value, wt, value.length, W, dp));
    }
}
