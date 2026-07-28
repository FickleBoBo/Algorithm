package day_29.prms_118668;

import java.util.*;

class Solution {

    static int INF = 1_000_000_000;

    public int solution(int alp, int cop, int[][] problems) {
        int alp_max = 0;
        int cop_max = 0;
        for (int[] p : problems) {
            alp_max = Math.max(alp_max, p[0]);
            cop_max = Math.max(cop_max, p[1]);
        }
        alp = Math.min(alp, alp_max);
        cop = Math.min(cop, cop_max);

        int[][] dp = new int[1 + alp_max + 1][1 + cop_max + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, INF);
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= alp_max; i++) {
            for (int j = cop; j <= cop_max; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] p : problems) {
                    if (i < p[0] || j < p[1]) continue;

                    int ni = Math.min(i + p[2], alp_max);
                    int nj = Math.min(j + p[3], cop_max);
                    dp[ni][nj] = Math.min(dp[ni][nj], dp[i][j] + p[4]);
                }
            }
        }

        return dp[alp_max][cop_max];
    }
}
