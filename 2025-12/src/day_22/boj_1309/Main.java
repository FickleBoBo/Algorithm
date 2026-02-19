package day_22.boj_1309;

import java.io.*;

public class Main {

    static int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[1 + n][2];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = (2 * dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        System.out.println((dp[n][0] + dp[n][1]) % MOD);
    }
}
