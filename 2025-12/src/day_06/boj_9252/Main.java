package day_06.boj_9252;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int N = str1.length;
        int M = str2.length;

        int[][] dp = new int[1 + N][1 + M];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        sb.append(dp[N][M]).append("\n");
        if (dp[N][M] != 0) sb.append(traceback(str1, str2, dp));

        System.out.println(sb);
    }

    static String traceback(char[] str1, char[] str2, int[][] dp) {
        StringBuilder sb = new StringBuilder();

        int r = str1.length - 1;
        int c = str2.length - 1;

        while (r >= 0 && c >= 0) {
            if (str1[r] == str2[c]) {
                sb.append(str1[r]);
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
