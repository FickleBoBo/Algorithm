package day_11.boj_3067;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[1 + N];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[][] dp = new int[1 + N][1 + M];
            dp[0][0] = 1;  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 1가지
            for (int i = 1; i <= N; i++) {
                int coin = coins[i];

                for (int j = 0; j <= M; j++) {
                    if (j < coin) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                    }
                }
            }

            sb.append(dp[N][M]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
