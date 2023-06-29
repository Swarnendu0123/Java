import java.util.*;

public class text {
    public static int[] twoSum(int[] data, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for (int i = 0; i < data.length; i++) {
            if (map.containsKey(target - data[i])) {
                ans[0] = map.get(target - data[i]);
                ans[1] = i;
                return ans;
            }
            map.put(data[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = { 3, 2, 4 };
        int target = 6;
        int[] ans = twoSum(data, target);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
