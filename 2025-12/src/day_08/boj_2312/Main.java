package day_08.boj_2312;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> primes = getPrimes(sieve());

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int p : primes) {
                if (p * p > n) break;  // prime의 제곱보다 작으면 탐색 종료

                int cnt = 0;
                while (n % p == 0) {
                    n /= p;
                    cnt++;
                }

                if (cnt > 0) sb.append(p).append(" ").append(cnt).append("\n");
            }

            if (n > 1) sb.append(n).append(" 1\n");  // N이 처음부터 소수인 경우와 합성수를 소인수분해한 후 소수가 남은 경우
        }

        System.out.println(sb);
    }

    static boolean[] sieve() {
        boolean[] isPrime = new boolean[1 + MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
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
