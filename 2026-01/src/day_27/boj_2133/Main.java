package day_27.boj_2133;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[31];
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] += dp[i - 2] * 3 + 2;

            for (int j = i - 4; j >= 2; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
