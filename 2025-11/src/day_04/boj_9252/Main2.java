package day_04.boj_9252;

import java.io.*;

public class Main2 {

    private static int[][] dp;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int N = str1.length;
        int M = str2.length;

        dp = new int[N][M];
        visited = new boolean[N][M];

        sb.append(lcs(str1, N - 1, str2, M - 1)).append('\n');

        if (dp[N - 1][M - 1] != 0) {
            sb.append(traceback(str1, str2, N, M));
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int lcs(char[] str1, int len1, char[] str2, int len2) {
        if (len1 == -1 || len2 == -1) return 0;

        if (visited[len1][len2]) return dp[len1][len2];

        visited[len1][len2] = true;
        if (str1[len1] == str2[len2]) {
            return dp[len1][len2] = lcs(str1, len1 - 1, str2, len2 - 1) + 1;
        } else {
            return dp[len1][len2] = Math.max(lcs(str1, len1 - 1, str2, len2), lcs(str1, len1, str2, len2 - 1));
        }
    }

    // 역추적
    private static String traceback(char[] str1, char[] str2, int N, int M) {
        StringBuilder sb = new StringBuilder();

        int r = N - 1;
        int c = M - 1;

        while (r >= 0 && c >= 0) {
            if (str1[r] == str2[c]) {
                sb.append(str1[r]);
                r--;
                c--;
            } else {
                if (r == 0) {
                    c--;
                } else if (c == 0) {
                    r--;
                } else {
                    if (dp[r - 1][c] > dp[r][c - 1]) {
                        r--;
                    } else {
                        c--;
                    }
                }
            }
        }

        return sb.reverse().toString();
    }
}
