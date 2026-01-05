package day_05.prms_12900;

class Solution {

    static final int MOD = 1_000_000_007;

    public int solution(int n) {
        if (n == 1) return 1;

        int[] dp = new int[1 + n];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        return dp[n];
    }
}
