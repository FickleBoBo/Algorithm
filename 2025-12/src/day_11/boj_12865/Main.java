package day_11.boj_12865;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] warr = new int[1 + n];
        int[] varr = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            warr[i] = Integer.parseInt(st.nextToken());
            varr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + n][1 + k];
        for (int i = 1; i <= n; i++) {
            int w = warr[i];
            int v = varr[i];

            for (int j = 1; j <= k; j++) {
                if (j < w) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - w] + v, dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
