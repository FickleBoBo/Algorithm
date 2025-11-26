package day_27.boj_2960;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(sieve(N, K));
    }

    // 에라토스테네스의 체
    private static int sieve(int N, int K) {
        boolean[] isPrime = new boolean[1 + N];
        Arrays.fill(isPrime, 2, N + 1, true);
        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                cnt++;
                if (cnt == K) return i;

                for (int j = i * i; j <= N; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;

                        cnt++;
                        if (cnt == K) return j;
                    }
                }
            }
        }

        return -1;
    }
}
