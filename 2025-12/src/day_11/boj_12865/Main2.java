package day_11.boj_12865;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] warr = new int[n];
        int[] varr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            warr[i] = Integer.parseInt(st.nextToken());
            varr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + k];
        for (int i = 0; i < n; i++) {
            int w = warr[i];
            int v = varr[i];

            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j - w] + v, dp[j]);
            }
        }

        System.out.println(dp[k]);
    }
}
