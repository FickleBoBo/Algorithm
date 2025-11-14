package day_11.boj_17528;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[1 + N];
        int[] B = new int[1 + N];
        int sumA = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            sumA += A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + N][1 + sumA];
        for (int i = 1; i <= N; i++) {
            int a = A[i];
            int b = B[i];

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
            min = Math.min(min, Math.max(j, dp[N][j]));
        }

        System.out.println(min);
    }
}
