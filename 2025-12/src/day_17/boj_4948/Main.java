package day_17.boj_4948;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 123456 * 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = sieve(MAX);

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
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
