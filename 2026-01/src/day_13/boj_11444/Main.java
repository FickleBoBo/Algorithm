package day_13.boj_11444;

import java.io.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }

        long[][] res = binPow(baseMatrix(), N - 1);
        System.out.println(res[0][0]);
    }

    static long[][] binPow(long[][] mat, long n) {
        long[][] res = identity();

        while (n > 0) {
            if ((n & 1) > 0) res = multiply(res, mat);
            mat = multiply(mat, mat);
            n >>= 1;
        }

        return res;
    }

    static long[][] identity() {
        return new long[][]{
                {1, 0},
                {0, 1},
        };
    }

    static long[][] baseMatrix() {
        return new long[][]{
                {1, 1},
                {1, 0},
        };
    }

    static long[][] multiply(long[][] m1, long[][] m2) {
        return new long[][]{
                {(m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % MOD, (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % MOD},
                {(m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % MOD, (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % MOD}
        };
    }
}
