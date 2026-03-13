package day_06.boj_9252;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int n = s1.length;
        int m = s2.length;

        int[][] dp = new int[1 + n][1 + m];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        sb.append(dp[n][m]).append("\n");
        if (dp[n][m] != 0) sb.append(traceback(s1, s2, dp));

        System.out.println(sb);
    }

    static String traceback(char[] s1, char[] s2, int[][] dp) {
        StringBuilder sb = new StringBuilder();

        int r = s1.length - 1;
        int c = s2.length - 1;

        while (r >= 0 && c >= 0) {
            if (s1[r] == s2[c]) {
                sb.append(s1[r]);
                r--;
                c--;
            } else {
                if (dp[r][c + 1] > dp[r + 1][c]) {
                    r--;
                } else {
                    c--;
                }
            }
        }

        return sb.reverse().toString();
    }
}
