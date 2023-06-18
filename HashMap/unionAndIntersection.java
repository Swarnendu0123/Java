import java.util.*;

public class unionAndIntersection {
    public static void main(String[] args) {
        int data1[] = { 7, 3, 9 };
        int data2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> union = new HashSet<>();
        HashSet<Integer> intersection2 = new HashSet<>();
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < data1.length; i++) {
            union.add(data1[i]);
            intersection2.add(data1[i]);
        }
        for (int i = 0; i < data2.length; i++) {
            union.add(data2[i]);
        }
        System.out.println(union + ", size=" + union.size());
        for (int numb : data2) {
            if (intersection2.contains(numb)) {
                intersection2.remove(numb);
                intersection.add(numb);
            }
        }
        System.out.println(intersection + ", size=" + intersection.size());
    }
}
