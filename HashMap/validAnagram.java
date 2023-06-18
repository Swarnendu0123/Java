import java.util.*;

public class validAnagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        in.close();
        if (s.length() != t.length()) {
            System.out.println(false);
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                System.out.println(false);
                return;
            }
            int n = map.get(t.charAt(i));
            if (n == 1) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), n - 1);
            }
        }
        if (map.isEmpty()) {
            System.out.println(true);
            return;
        } else {
            System.out.println(false);
            return;
        }
    }
}
