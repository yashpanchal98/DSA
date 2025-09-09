class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        
        long[] dp = new long[n + 1];
        dp[1] = 1;

        long activeSharers = 0;
        
        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                activeSharers = (activeSharers + dp[day - delay]) % MOD;
            }
            if (day - forget >= 1) {
                activeSharers = (activeSharers - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = activeSharers;
        }

        long result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                result = (result + dp[day]) % MOD;
            }
        }

        return (int) result;
    }
}