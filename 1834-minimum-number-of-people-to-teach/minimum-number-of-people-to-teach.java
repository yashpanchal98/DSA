class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        HashSet<Integer> badUsers = new HashSet<>();

        for (int i = 0; i < friendships.length; i++) {
            int p1 = friendships[i][0] - 1; 
            int p2 = friendships[i][1] - 1;

            HashSet<Integer> hs = new HashSet<>();
            for (int j = 0; j < languages[p1].length; j++) {
                hs.add(languages[p1][j]);
            }

            boolean common = false;
            for (int j = 0; j < languages[p2].length; j++) {
                if (hs.contains(languages[p2][j])) {
                    common = true;
                    break;
                }
            }

            if (!common) {
                badUsers.add(p1);
                badUsers.add(p2);
            }
        }

        if (badUsers.isEmpty()) {
            return 0;
        }

        int answer = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : badUsers) {
                boolean knows = false;
                for (int l : languages[user]) {
                    if (l == lang) {
                        knows = true;
                        break;
                    }
                }
                if (!knows) count++; 
            }
            answer = Math.min(answer, count);
        }

        return answer;
    }
}