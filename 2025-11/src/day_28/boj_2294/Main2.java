package day_28.boj_2294;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final int MAX = 10_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[1 + k];
        Arrays.fill(dp, 1, k + 1, MAX);
        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
            }
        }

        if (dp[k] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
