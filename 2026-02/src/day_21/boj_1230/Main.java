package day_21.boj_1230;

import java.io.*;

public class Main {

    static final int INF = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int n = str1.length;
        int m = str2.length;

        int[][] match = new int[1 + n][1 + m];
        int[][] insert = new int[1 + n][1 + m];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                match[i][j] = insert[i][j] = INF;
            }
        }

        match[0][0] = 0;
        for (int j = 1; j <= m; j++) {
            insert[0][j] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    match[i][j] = Math.min(match[i - 1][j - 1], insert[i - 1][j - 1]);
                }
                insert[i][j] = Math.min(match[i][j - 1] + 1, insert[i][j - 1]);
            }
        }

        int result = Math.min(match[n][m], insert[n][m]);
        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
