package day_09.boj_1644;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        List<Integer> primes = getPrimes(sieve(n));
        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while (true) {
            if (sum < n) {
                sum += primes.get(right++);
            } else {
                if (sum == n) cnt++;
                sum -= primes.get(left++);
            }

            if (right == primes.size() && sum < n) break;
        }

        System.out.println(cnt);
    }

    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[1 + n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
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
