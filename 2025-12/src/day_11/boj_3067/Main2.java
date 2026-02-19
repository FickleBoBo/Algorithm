package day_11.boj_3067;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] coins = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());

            int[] dp = new int[1 + m];
            dp[0] = 1;  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 1가지
            for (int coin : coins) {
                for (int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);
    }
}
