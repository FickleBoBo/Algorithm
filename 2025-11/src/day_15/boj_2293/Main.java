package day_15.boj_2293;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[1 + n][1 + k];
        dp[0][0] = 1;  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 1가지
        for (int i = 1; i <= n; i++) {
            int coin = coins[i];

            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= coin) {
                    dp[i][j] += dp[i][j - coin];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
