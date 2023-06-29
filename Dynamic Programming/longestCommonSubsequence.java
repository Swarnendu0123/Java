public class longestCommonSubsequence {
    // recursion
    public static int longestCommonSubSeq(int m, int n, String s1, String s2) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return longestCommonSubSeq(m - 1, n - 1, s1, s2) + 1;
        } else {
            int ans1 = longestCommonSubSeq(m - 1, n, s1, s2);
            int ans2 = longestCommonSubSeq(m, n - 1, s1, s2);
            return Math.max(ans1, ans2);
        }
    }

    // memoization
    public static int longestCommonSubSeq(int m, int n, String s1, String s2, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return longestCommonSubSeq(m - 1, n - 1, s1, s2, dp) + 1;
        } else {
            int ans1 = longestCommonSubSeq(m - 1, n, s1, s2, dp);
            int ans2 = longestCommonSubSeq(m, n - 1, s1, s2, dp);
            return Math.max(ans1, ans2);
        }
    }

    // tabulation
    public static int longestCommonSubSeqTab(int m, int n, String s1, String s2) {
        // initialization
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abcdge";
        String s2 = "abedg";
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("recursion: " + longestCommonSubSeq(m, n, s1, s2));
        System.out.println("memorization: " + longestCommonSubSeq(m, n, s1, s2, dp));
        System.out.println("Tabulation: " + longestCommonSubSeqTab(m, n, s1, s2));
    }
}