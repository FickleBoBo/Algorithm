package day_05.boj_11727;

import java.io.*;

public class Main {

    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[1 + n];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 2] + dp[i - 1]) % MOD;
        }

        System.out.println(dp[n]);
    }
}
