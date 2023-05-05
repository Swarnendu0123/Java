import java.util.*;

public class findSubsetOfaString {
    static int count = 1;

    public static void findSubset(String str, StringBuilder ans, int i) {
        // base case
        if (ans.length() == 0 && count == Math.pow(2, str.length())) {
            System.out.println(count + " ");
            return;
        } else if (i == str.length()) {
            System.out.println(count + " " + ans);
            count++;
            ans.deleteCharAt(ans.length() - 1);
            return;
        }
        // recurtion step
        // choice yes
        findSubset(str, ans.append(str.charAt(i)), i + 1);
        // choice no
        findSubset(str, ans, ++i);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder ans = new StringBuilder("");
        System.out.print("enter string: ");
        String str = in.next();
        System.out.print("printing substrings ... ");
        findSubset(str, ans, 0);
    }
}
