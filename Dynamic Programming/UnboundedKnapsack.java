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

    // by memoization
    public static int knapsackMemo(int value[], int wt[], int n, int W, int[][] dp) {
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

    public static void main(String[] args) {
        int[] value = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsack(value, wt, value.length, W));
    }
}
