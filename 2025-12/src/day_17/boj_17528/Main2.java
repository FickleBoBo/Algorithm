package day_17.boj_17528;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] aarr = new int[n];
        int[] barr = new int[n];
        int sumA = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sumA += aarr[i] = Integer.parseInt(st.nextToken());
            barr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + sumA];
        for (int i = 0; i < n; i++) {
            int a = aarr[i];
            int b = barr[i];

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
