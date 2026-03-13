package day_06.boj_1958;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        char[] s3 = br.readLine().toCharArray();
        int l = s1.length;
        int m = s2.length;
        int n = s3.length;

        int[][][] dp = new int[1 + l][1 + m][1 + n];
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    if (s1[i - 1] == s2[j - 1] && s2[j - 1] == s3[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }

        System.out.println(dp[l][m][n]);
    }
}
