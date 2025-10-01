package day_02.prms_12900;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int solution(int n) {
        int[] dp = new int[1 + n];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}
