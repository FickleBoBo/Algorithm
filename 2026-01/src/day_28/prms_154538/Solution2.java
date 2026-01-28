package day_28.prms_154538;

import java.util.*;

class Solution2 {

    static final int MAX = 1_000_000;

    public int solution(int x, int y, int n) {
        int[] dp = new int[1 + y * 3];
        Arrays.fill(dp, MAX);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }

        return dp[y] == MAX ? -1 : dp[y];
    }
}
