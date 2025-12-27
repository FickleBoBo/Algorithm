package day_22.boj_1309;

import java.io.*;

public class Main2 {

    static int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int skip = 1;
        int take = 0;

        for (int i = 1; i <= N; i++) {
            int prev = skip;
            skip = (skip + take) % MOD;
            take = (2 * prev + take) % MOD;
        }

        System.out.println((skip + take) % MOD);
    }
}
