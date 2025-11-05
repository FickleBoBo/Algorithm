package day_05.boj_11051;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 10_007;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[1 + N][1 + K];

        System.out.println(nCr(N, K));
    }

    private static int nCr(int n, int r) {
        if (r == 0 || n == r) return 1;
        if (r == 1) return n;

        if (dp[n - 1][r] == 0) {
            dp[n - 1][r] = nCr(n - 1, r);
        }

        if (dp[n - 1][r - 1] == 0) {
            dp[n - 1][r - 1] = nCr(n - 1, r - 1);
        }

        return dp[n][r] = (dp[n - 1][r] + dp[n - 1][r - 1]) % MOD;
    }
}
