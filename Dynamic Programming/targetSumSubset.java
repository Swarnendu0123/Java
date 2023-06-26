import java.util.*;

public class targetSumSubset {
    public static ArrayList<Integer> ans = new ArrayList<>();

    // recursion
    public static boolean subSubSet(int[] data, int targetSum, int n) {
        // base case
        if (targetSum == 0) {
            return true;
        }
        if (n == data.length) {
            return false;
        }
        if (targetSum >= data[n]) {// then we can include
            // including condition
            ans.add(data[n]);
            if (subSubSet(data, targetSum - data[n], n + 1)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            // excluding condition
            if (subSubSet(data, targetSum, n + 1)) {
                return true;
            }
        } else {
            // excluding condition
            if (subSubSet(data, targetSum, n + 1)) {
                return true;
            }
        }
        return false;
    }

    // memoization
    public static boolean subSubSetMemo(int[] data, int targetSum, int n, boolean[][] dp) {
        // base case
        if (targetSum == 0) {
            dp[n][targetSum] = true;
            return true;
        }
        if (n == data.length) {
            dp[n][targetSum] = false;
            return false;
        }
        if (targetSum >= data[n]) {// then we can include
            // including condition
            ans.add(data[n]);
            if (dp[n][targetSum - data[n]]) {
                return true;
            } else {
                dp[n][targetSum - data[n]] = subSubSetMemo(data, targetSum - data[n], n + 1, dp);
                if (dp[n][targetSum - data[n]]) {
                    return true;
                }
            }
            ans.remove(ans.size() - 1);
            // excluding condition
            if (dp[n][targetSum]) {
                return true;
            } else {
                dp[n][targetSum] = subSubSetMemo(data, targetSum, n + 1, dp);
                if (dp[n][targetSum]) {
                    return true;
                }
            }
        } else {
            // excluding condition
            if (dp[n][targetSum]) {
                return true;
            } else {
                dp[n][targetSum] = subSubSetMemo(data, targetSum, n + 1, dp);
                if (dp[n][targetSum]) {
                    return true;
                }
            }
        }
        return false;
    }

    // tabulation
    public static boolean subSubSetTab(int[] data, int targetSum) {
        int n = data.length;
        // initialization
        boolean dp[][] = new boolean[data.length + 1][targetSum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                // check if i can include or not
                if (data[i - 1] <= j) {
                    // if I can from sum=(j-data) by i-1 element then I can also form sum+data=j
                    if (dp[i - 1][j - data[i - 1]]) {
                        dp[i][j] = true;
                    }
                    // exclude
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        print(dp);
        return dp[n][targetSum];
    }

    public static void print(boolean[][] dp) {
        System.out.println(dp.length);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int data[] = { 4, 2, 7, 1, 3 };
        int targetSum = in.nextInt();
        System.out.println(subSubSetMemo(data, targetSum, 0, new boolean[data.length + 1][targetSum + 1]));
        System.out.println(ans);
        System.out.println();
        System.out.println();
        System.out.println(subSubSetTab(data, targetSum));
    }
}
