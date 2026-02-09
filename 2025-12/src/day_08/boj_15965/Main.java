package day_08.boj_15965;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 7_368_787;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        boolean[] isPrime = sieve();
        int cnt = 0;

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) cnt++;

            if (cnt == k) {
                System.out.println(i);
                break;
            }
        }
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
}
