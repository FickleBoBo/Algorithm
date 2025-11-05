package day_04.boj_9251;

import java.io.*;

public class Main2 {

    private static int[][] dp;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int N = str1.length;
        int M = str2.length;

        dp = new int[N][M];
        visited = new boolean[N][M];

        System.out.println(lcs(str1, N - 1, str2, M - 1));
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
}
