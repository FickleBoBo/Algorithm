package day_08.boj_2312;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> primes = getPrimes(sieve(MAX));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            for (int prime : primes) {
                if (prime * prime > N) break;  // prime의 제곱보다 작으면 탐색 종료

                int cnt = 0;
                while (N % prime == 0) {
                    N /= prime;
                    cnt++;
                }

                if (cnt > 0) sb.append(prime).append(" ").append(cnt).append("\n");
            }

            if (N > 1) sb.append(N).append(" 1\n");  // N이 처음부터 소수인 경우와 합성수를 소인수분해한 후 소수가 남은 경우
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

    static List<Integer> getPrimes(boolean[] isPrime) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }
}
