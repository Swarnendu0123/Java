import java.util.*;

public class LinkedHashMapPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Chaina", 200);
        hm.put("USA", 120);
        hm.put("Africa", 50);
        hm.put("BangalaDesh", 500);

        System.out.println(hm);

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("Chaina", 200);
        lhm.put("USA", 120);
        lhm.put("Africa", 50);
        lhm.put("BangalaDesh", 500);

        System.out.println(lhm);// follows order of insrtion

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("Chaina", 200);
        tm.put("USA", 120);
        tm.put("Africa", 50);
        tm.put("BangalaDesh", 500);
        System.out.println(tm);// sorted by keys
    }
}
