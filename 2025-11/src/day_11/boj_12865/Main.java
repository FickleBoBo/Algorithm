package day_11.boj_12865;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[1 + N];
        int[] V = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + N][1 + K];
        for (int i = 1; i <= N; i++) {
            int w = W[i];
            int v = V[i];

            for (int j = 1; j <= K; j++) {
                if (j < w) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - w] + v, dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
