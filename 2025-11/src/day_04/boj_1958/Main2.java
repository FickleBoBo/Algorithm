package day_04.boj_1958;

import java.io.*;

public class Main2 {

    private static int[][][] dp;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        char[] str3 = br.readLine().toCharArray();
        int L = str1.length;
        int M = str2.length;
        int N = str3.length;

        dp = new int[L][M][N];
        visited = new boolean[L][M][N];

        System.out.println(lcs(str1, L - 1, str2, M - 1, str3, N - 1));
    }

    private static int lcs(char[] str1, int len1, char[] str2, int len2, char[] str3, int len3) {
        if (len1 == -1 || len2 == -1 || len3 == -1) return 0;

        if (visited[len1][len2][len3]) return dp[len1][len2][len3];

        visited[len1][len2][len3] = true;
        if (str1[len1] == str2[len2] && str2[len2] == str3[len3]) {
            return dp[len1][len2][len3] = lcs(str1, len1 - 1, str2, len2 - 1, str3, len3 - 1) + 1;
        } else {
            return dp[len1][len2][len3] = Math.max(lcs(str1, len1 - 1, str2, len2, str3, len3), Math.max(lcs(str1, len1, str2, len2 - 1, str3, len3), lcs(str1, len1, str2, len2, str3, len3 - 1)));
        }
    }
}
