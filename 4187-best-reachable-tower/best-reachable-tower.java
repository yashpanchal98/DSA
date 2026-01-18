class Solution {

    public int[] bestTower(int[][] towers, int[] center, int radius) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int ox = center[0];
        int oy = center[1];

        for (int i = 0; i < towers.length; i++) {
            int x = towers[i][0];
            int y = towers[i][1];
            int p = towers[i][2];

            int dist = Math.abs(x - ox) + Math.abs(y - oy);
            if (dist <= radius) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                list.add(p);
                ans.add(list);
            }
        }

        if (ans.size() == 0) return new int[]{-1, -1};

        Collections.sort(ans, (a, b) -> {

            if (!a.get(2).equals(b.get(2))) {
                return b.get(2) - a.get(2);
            }

            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            }
            return a.get(1) - b.get(1);
        });

        return new int[]{ans.get(0).get(0), ans.get(0).get(1)};
    }
}