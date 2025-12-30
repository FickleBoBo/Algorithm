package day_30.boj_11402;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1 + M][1 + M];
        for (int i = 0; i <= M; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % M;
            }
        }

        long ans = 1;

        // 뤼카의 정리
        while (N > 0) {
            // N, K를 M진법으로 변환시 자릿수
            int ni = (int) (N % M);
            int ki = (int) (K % M);

            if (ni < ki) {
                ans = 0;
                break;
            }

            ans = ans * dp[ni][ki] % M;

            // 다음 자릿수로 이동하는 효과
            N = N / M;
            K = K / M;
        }

        System.out.println(ans);
    }
}
