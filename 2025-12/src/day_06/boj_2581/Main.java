package day_06.boj_2581;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = N;
        boolean[] isPrime = sieve(N);

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    static boolean[] sieve(int N) {
        boolean[] isPrime = new boolean[1 + N];
        Arrays.fill(isPrime, 2, N + 1, true);

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
