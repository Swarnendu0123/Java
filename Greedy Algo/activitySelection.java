import java.util.*;

public class activitySelection {
    public static void main(String[] args) {
        int start[] = { 3, 0, 8, 5, 1, 5 };
        // activity is sorted according to end time
        int end[] = { 4, 6, 9, 9, 2, 7 };

        // sorting
        int activitys[][] = new int[start.length][3];

        for (int i = 0; i < activitys.length; i++) {
            activitys[i][0] = i;// index
            activitys[i][1] = start[i];// start
            activitys[i][2] = end[i];// end
        }

        // lembda function
        Arrays.sort(activitys, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // last activity inilization
        maxAct++;
        ans.add(activitys[0][0]);
        int lastEnd = activitys[0][2];

        for (int i = 0; i < end.length; i++) {
            // non overlaping
            if (activitys[i][1] >= lastEnd) {
                maxAct++;
                lastEnd = activitys[i][2];
                ans.add(activitys[i][0]);
            }
        }
        System.out.println("max activity = " + maxAct);
        System.out.println("Activity index = " + ans);
    }
}
