package day_11.boj_12865;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N];
        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + K];
        for (int i = 0; i < N; i++) {
            int w = W[i];
            int v = V[i];

            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j - w] + v, dp[j]);
            }
        }

        System.out.println(dp[K]);
    }
}
