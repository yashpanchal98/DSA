import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> sunny = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                sunny.add(i);
                ans[i] = 1; 
            } else {
                int lake = rains[i];
                if (full.containsKey(lake)) {

                    Integer dryDay = sunny.higher(full.get(lake));
                    if (dryDay == null) {
                        return new int[0];
                    }
                    ans[dryDay] = lake; 
                    sunny.remove(dryDay);
                }
                full.put(lake, i); 
                ans[i] = -1; 
            }
        }
        return ans;
    }
}