package day_30.boj_11401;

import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] fact = initFact(N);  // 팩토리얼 배열
        long[] invFact = initInvFact(N, fact[N]);  // 역팩토리얼 배열

        System.out.println(fact[N] * invFact[K] % MOD * invFact[N - K] % MOD);
    }

    static long[] initFact(int N) {
        long[] fact = new long[1 + N];
        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        return fact;
    }

    static long[] initInvFact(int N, long a) {
        long[] invFact = new long[1 + N];
        invFact[N] = modPow(a, MOD - 2);  // 역팩토리얼의 초항(페르마의 소정리 활용)

        for (int i = N - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        return invFact;
    }

    static long modPow(long a, int b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) > 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }

        return res;
    }
}
