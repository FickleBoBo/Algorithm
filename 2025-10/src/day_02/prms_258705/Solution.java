package day_02.prms_258705;

class Solution {

    private static final int MOD = 10_007;

    public int solution(int n, int[] tops) {
        int[] dp = new int[1 + n];
        dp[0] = 1;  // 삼각형 하나만 있는 경우 조합의 수는 1
        dp[1] = tops[0] == 0 ? 3 : 4;

        for (int i = 2; i <= n; i++) {
            // 뺄셈 과정에서 모듈러 연산 때문에 음수가 나올 수 있어서 MOD를 더하고 나머지를 구함
            if (tops[i - 1] == 0) {
                dp[i] = (dp[i - 1] * 3 - dp[i - 2] + MOD) % MOD;
            } else {
                dp[i] = (dp[i - 1] * 4 - dp[i - 2] + MOD) % MOD;
            }
        }

        return dp[n];
    }
}
