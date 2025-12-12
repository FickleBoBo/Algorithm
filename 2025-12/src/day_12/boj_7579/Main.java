package day_12.boj_7579;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] mArr = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cArr = new int[1 + N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum += cArr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + N][1 + sum];
        for (int i = 1; i <= N; i++) {
            int m = mArr[i];
            int c = cArr[i];

            for (int j = 0; j <= sum; j++) {
                if (j < c) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
                }
            }
        }

        for (int j = 0; j <= sum; j++) {
            if (dp[N][j] >= M) {
                System.out.println(j);
                return;
            }
        }
    }
}
