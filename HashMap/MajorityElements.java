import java.util.*;

public class MajorityElements {// O(n)
    public static void main(String[] args) {
        int data[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            // if (hm.containsKey(data[i])) {// O(1)
            // hm.put(data[i], (hm.get(data[i])) + 1);// O(1)//O(1)
            // } else {
            // hm.put(data[i], 1);// O(1)
            // }
            hm.put(data[i], hm.getOrDefault(data[i], 0) + 1);
        }

        for (Integer key : hm.keySet()) { // O(n)
            if (hm.get(key) > (data.length / 3)) {
                System.out.println(key);
            }
        }
    }
}
