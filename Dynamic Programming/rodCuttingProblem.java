public class rodCuttingProblem {
    public static int rodcutting(int n, int[] length, int[] price, int rodLength, int[][] dp) {
        if (n == 0 || rodLength == 0) {
            return 0;
        }
        if (dp[n][rodLength] != -1) {
            return dp[n][rodLength];
        }
        if (length[n - 1] <= rodLength) {
            // include
            int ans1 = rodcutting(n, length, price, rodLength - length[n - 1], dp) + price[n - 1];
            // exclude
            int ans2 = rodcutting(n - 1, length, price, rodLength, dp);
            dp[n][rodLength] = Math.max(ans1, ans2);
            return dp[n][rodLength];
        } else {
            dp[n][rodLength] = rodcutting(n - 1, length, price, rodLength, dp);
            return dp[n][rodLength];
        }
    }

    public static void main(String[] args) {
        int[] value = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;
        int[][] dp = new int[value.length + 1][rodLength + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp.length; j++) {
            dp[0][j] = 0;
        }
        int ans = rodcutting(value.length, value, price, rodLength, dp);
        System.out.println(ans);
    }
}
