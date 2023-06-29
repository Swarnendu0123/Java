import java.util.*;

public class longestCommonSubString {
    // tabulation
    public static int longestCommonSubStr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int ans = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    // menoization
    public static int longestCommonSubSeqMemo(String s1, String s2) {
        // initialization
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        longestCommonSubStrUtil(s1, s2, m, n, dp);
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static int longestCommonSubStrUtil(String s1, String s2, int m, int n, int dp[][]) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = longestCommonSubStrUtil(s1, s2, m - 1, n - 1, dp) + 1;
            return dp[m][n];
        } else {
            longestCommonSubStrUtil(s1, s2, m - 1, n, dp);
            longestCommonSubStrUtil(s1, s2, m, n - 1, dp);
            return 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "ABCDEH";
        String s2 = "ABCDGH";

        System.out.println(longestCommonSubStr(s1, s2));
        System.out.println(longestCommonSubSeqMemo(s1, s2));
    }
}
