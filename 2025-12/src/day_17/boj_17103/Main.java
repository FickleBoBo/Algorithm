package day_17.boj_17103;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = sieve(MAX);

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;
            for (int i = 2; i <= N / 2; i++) {
                if (isPrime[i] && isPrime[N - i]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static boolean[] sieve(int N) {
        boolean[] isPrime = new boolean[1 + N];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
