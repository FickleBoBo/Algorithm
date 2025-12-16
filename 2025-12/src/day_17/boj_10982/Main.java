package day_17.boj_10982;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] A = new int[N];
            int[] B = new int[N];
            int sumA = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                sumA += A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][1 + sumA];  // 토글링 dp
            int prev = 0;
            int cur = 1;
            for (int i = 0; i < N; i++) {
                int a = A[i];
                int b = B[i];

                for (int j = 0; j <= sumA; j++) {
                    if (j < a) {
                        dp[cur][j] = dp[prev][j] + b;
                    } else {
                        dp[cur][j] = Math.min(dp[prev][j - a], dp[prev][j] + b);
                    }
                }

                // 토글링
                prev ^= 1;
                cur ^= 1;
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= sumA; j++) {
                min = Math.min(min, Math.max(j, dp[prev][j]));  // 토글링 때문에 최신값이 prev에 있음
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
