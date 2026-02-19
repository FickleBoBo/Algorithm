package day_12.boj_7579;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] marr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        int[] carr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += carr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + sum];
        for (int i = 0; i < n; i++) {
            int m = marr[i];
            int c = carr[i];

            for (int j = sum; j >= c; j--) {
                dp[j] = Math.max(dp[j - c] + m, dp[j]);
            }
        }

        for (int j = 0; j <= sum; j++) {
            if (dp[j] >= k) {
                System.out.println(j);
                return;
            }
        }
    }
}
