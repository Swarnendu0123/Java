public class coinChallenge {

    // tabulation
    public static int coinChal(int[] value, int sum) {
        // initialization
        int n = value.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (value[i - 1] <= j) {
                    dp[i][j] = dp[i][j - value[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[value.length][sum];
    }

    public static void main(String[] args) {
        int[] value = { 2, 5, 3, 6 };
        int sum = 10;

        System.out.println(coinChal(value, sum));
    }
}
