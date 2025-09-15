class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arrivals.length;
        boolean discard[] = new boolean[n];

        int left = 0;
        int right = 0;

        for (right = 0; right < w && right < n; right++) {

            map.put(arrivals[right], map.getOrDefault(arrivals[right], 0) + 1);

            if (map.get(arrivals[right]) > m) {
                discard[right] = true;
                int freq = map.get(arrivals[right]);
                if (freq == 1)
                    map.remove(arrivals[right]);
                else
                    map.put(arrivals[right], freq - 1);
            }
        }

        while (right < n) {

            map.put(arrivals[right], map.getOrDefault(arrivals[right], 0) + 1);

            while (right - left + 1 > w) {
                if (map.containsKey(arrivals[left])) {
                    int freq = map.get(arrivals[left]);
                    if(discard[left]==true){
                        left++;
                        break;
                    } 
                    if (freq == 1)
                        map.remove(arrivals[left]);
                    else
                        map.put(arrivals[left], freq - 1);
                }

                left++;
            }

            if (map.getOrDefault(arrivals[right],0) > m) {
                discard[right] = true;
                if (map.containsKey(arrivals[right])) {
                    int freq = map.get(arrivals[right]);
                    if (freq == 1)
                        map.remove(arrivals[right]);
                    else
                        map.put(arrivals[right], freq - 1);
                }

            }
            right++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (discard[i])
                ans++;
        }

        return ans;

    }
}