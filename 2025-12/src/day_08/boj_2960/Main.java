package day_08.boj_2960;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(sieve(n, k));
    }

    static int sieve(int n, int k) {
        boolean[] isPrime = new boolean[1 + n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                cnt++;
                if (cnt == k) return i;

                for (int j = i * i; j <= n; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;

                        cnt++;
                        if (cnt == k) return j;
                    }
                }
            }
        }

        return -1;
    }
}
