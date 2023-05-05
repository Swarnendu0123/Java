import java.util.*;

public class pangram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        // removing spaces
        str = str.replace(" ", "");

        // converting to lower case
        str = str.toLowerCase();
        char carr[] = str.toCharArray();
        if (carr.length < 26) {
            System.out.println("Not an anagram");
            return;
        }

        // data array is to check all the alphabet is present or not
        int data[] = new int[26];
        for (int i = 0; i < carr.length; i++) {
            data[carr[i] - 'a'] = 1;
        }

        // final checking on data array
        for (int i = 0; i < data.length; i++) {
            // if any of index is 0 then corresponding charracter is not present
            if (data[i] == 0) {
                System.out.println("Not an anagram");
                return;
            }
        }

        // printing aangram
        System.out.println("Anagram");
    }
}
