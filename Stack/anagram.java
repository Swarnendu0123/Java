import java.util.*;

public class anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        // removing spaces
        str1 = str1.replace(" ", "");
        str2 = str2.replace(" ", "");
        // converting to lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        // if they are of different length then return no
        if (str1.length() != str2.length()) {
            System.out.println("Not an Anagram");
            return;
        }
        // converting to character array
        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();
        // sorting to arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // checking
        for (int i = 0; i < str1.length() - 1; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("Not an Anagram");
                return;
            }
        }
        System.out.println("Anagram");
    }
}