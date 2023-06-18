import java.util.*;

public class itraryFromTickets {

    public static String getStarting(HashMap<String, String> map) {
        String sp = "";
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : map.keySet()) {
            revMap.put(map.get(key), key);
        }
        for (String key : map.keySet()) {
            if (!revMap.containsKey(key)) {
                sp = key;
                return sp;
            }
        }
        return sp;
    }

    public static void main(String[] args) {
        HashMap<String, String> tick = new HashMap<>();
        tick.put("Chennai", "Bangaluru");
        tick.put("Mumbai", "Delhi");
        tick.put("Goa", "Chennai");
        tick.put("Delhi", "Goa");
        String sp = getStarting(tick);
        for (String key : tick.keySet()) {
            System.out.print(sp + "->");
            sp = tick.get(sp);
        }
        System.out.println(sp);
    }
}
