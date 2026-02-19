package day_12.boj_7579;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] marr = new int[1 + n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        int[] carr = new int[1 + n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum += carr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + n][1 + sum];
        for (int i = 1; i <= n; i++) {
            int m = marr[i];
            int c = carr[i];

            for (int j = 0; j <= sum; j++) {
                if (j < c) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
                }
            }
        }

        for (int j = 0; j <= sum; j++) {
            if (dp[n][j] >= k) {
                System.out.println(j);
                return;
            }
        }
    }
}
