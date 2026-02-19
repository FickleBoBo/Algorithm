package day_12.boj_10830;

import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = binPow(mat, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] binPow(int[][] mat, long n) {
        int len = mat.length;
        int[][] res = identity(len);

        while (n > 0) {
            if ((n & 1) > 0) res = multiply(res, mat);
            mat = multiply(mat, mat);
            n >>= 1;
        }

        return res;
    }

    static int[][] identity(int len) {
        int[][] id = new int[len][len];
        for (int i = 0; i < len; i++) {
            id[i][i] = 1;
        }
        return id;
    }

    static int[][] multiply(int[][] mat1, int[][] mat2) {
        int len = mat1.length;
        int[][] res = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
                res[i][j] %= MOD;
            }
        }

        return res;
    }
}
