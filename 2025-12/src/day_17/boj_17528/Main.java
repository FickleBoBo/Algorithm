package day_17.boj_17528;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] aarr = new int[1 + n];
        int[] barr = new int[1 + n];
        int sumA = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            sumA += aarr[i] = Integer.parseInt(st.nextToken());
            barr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + n][1 + sumA];
        for (int i = 1; i <= n; i++) {
            int a = aarr[i];
            int b = barr[i];

            for (int j = 0; j <= sumA; j++) {
                if (j < a) {
                    dp[i][j] = dp[i - 1][j] + b;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - a], dp[i - 1][j] + b);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= sumA; j++) {
            min = Math.min(min, Math.max(j, dp[n][j]));
        }

        System.out.println(min);
    }
}
