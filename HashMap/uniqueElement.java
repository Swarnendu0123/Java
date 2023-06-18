import java.util.*;

public class uniqueElement {
    public static void main(String[] args) {
        int data[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
        int count = 0;
        for (Integer numb : set) {
            count++;
        }
        System.out.println(count);
        System.out.println(set);
    }
}
