package day_17.boj_16493;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] days = new int[1 + M];
        int[] pages = new int[1 + M];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + M][1 + N];
        for (int i = 1; i <= M; i++) {
            int day = days[i];
            int page = pages[i];

            for (int j = 1; j <= N; j++) {
                if (j < day) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - day] + page, dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[M][N]);
    }
}
