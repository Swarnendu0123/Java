import java.util.*;

public class activitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        // activity is sorted according to end time
        int end[] = { 2, 4, 6, 7, 9, 9 };
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // last activity
        maxAct++;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 0; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                lastEnd = end[i];
                ans.add(i);
            }
        }
        System.out.println(maxAct);
        System.out.println(ans);
    }
}
