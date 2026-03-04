package day_20.boj_3687;

import java.io.*;

public class Main {

    static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] dp = new String[1 + MAX];
        dp[2] = "1";
        dp[3] = "7";
        dp[4] = "4";
        dp[5] = "2";
        dp[6] = "6";
        dp[7] = "8";

        for (int i = 8; i <= MAX; i++) {
            for (int j = 2; j <= 7; j++) {
                if (dp[i - j] == null) continue;

                String tmp = dp[i - j];
                if (j != 6) {
                    tmp += dp[j];
                } else {
                    tmp += "0";
                }

                if (dp[i] == null) {
                    dp[i] = tmp;
                } else {
                    dp[i] = min(dp[i], tmp);
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append(" ").append(findMax(n)).append("\n");
        }

        System.out.println(sb);
    }

    static String min(String a, String b) {
        if (a.length() != b.length()) return a.length() > b.length() ? b : a;
        return a.compareTo(b) > 0 ? b : a;
    }

    static String findMax(int n) {
        if (n % 2 == 0) return "1".repeat(n / 2);
        return "7" + "1".repeat((n - 3) / 2);
    }
}
