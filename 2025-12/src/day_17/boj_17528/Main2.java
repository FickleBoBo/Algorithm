package day_17.boj_17528;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int sumA = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sumA += A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + sumA];
        for (int i = 0; i < N; i++) {
            int a = A[i];
            int b = B[i];

            for (int j = sumA; j >= 0; j--) {
                if (j < a) {
                    dp[j] += b;
                } else {
                    dp[j] = Math.min(dp[j - a], dp[j] + b);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= sumA; j++) {
            min = Math.min(min, Math.max(j, dp[j]));
        }

        System.out.println(min);
    }
}
