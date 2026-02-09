package day_30.boj_11402;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1 + m][1 + m];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % m;
            }
        }

        long ans = 1;

        // 뤼카의 정리
        while (n > 0) {
            // N, K를 M진법으로 변환시 자릿수
            int ni = (int) (n % m);
            int ki = (int) (k % m);

            if (ni < ki) {
                ans = 0;
                break;
            }

            ans = ans * dp[ni][ki] % m;

            // 다음 자릿수로 이동하는 효과
            n = n / m;
            k = k / m;
        }

        System.out.println(ans);
    }
}
