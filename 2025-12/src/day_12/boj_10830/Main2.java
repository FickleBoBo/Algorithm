package day_12.boj_10830;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int MOD = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = binPow(mat, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] binPow(int[][] mat, long n) {
        if (n == 0) return identity(mat.length);

        int[][] half = binPow(mat, n / 2);
        if (n % 2 == 1) {
            return multiply(multiply(half, half), mat);
        } else {
            return multiply(half, half);
        }
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
