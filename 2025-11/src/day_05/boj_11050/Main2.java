package day_05.boj_11050;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1 + N][1 + K];
        for (int n = 0; n <= N; n++) {
            dp[n][0] = 1;

            for (int r = 1; r <= Math.min(n, K); r++) {
                dp[n][r] = dp[n - 1][r] + dp[n - 1][r - 1];
            }
        }

        System.out.println(dp[N][K]);
    }
}
