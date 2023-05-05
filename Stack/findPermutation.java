import java.util.*;

import javax.swing.text.html.StyleSheet;

public class findPermutation {

    static int count = 1;

    public static void Permutation(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(count + " " + ans);
            count++;
            return;
        }
        // recurtion step
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String NewStr = str.substring(0, i) + str.substring(i + 1);
            Permutation(NewStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string :");
        String str = in.next();
        Permutation(str, "");
    }
}
