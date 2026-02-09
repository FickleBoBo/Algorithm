package day_29.boj_11051;

import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1 + n][1 + k];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
            }
        }

        System.out.println(dp[n][k]);
    }
}
