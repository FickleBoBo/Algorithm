package day_05.boj_11402;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] fact = initFact(M);  // 팩토리얼 배열
        int[] invFact = initInvFact(M, fact);  // 역팩토리얼 배열(모듈러 역원)
        long ans = 1;

        while (N > 0) {
            // N, K를 M진법으로 변환시 자릿수
            int ni = (int) (N % M);
            int ki = (int) (K % M);

            if (ni < ki) {
                ans = 0;
                break;
            }

            // 뤼카의 정리
            ans = ans * fact[ni] * invFact[ki] * invFact[ni - ki] % M;

            // 다음 자릿수로 이동하는 효과
            N = N / M;
            K = K / M;
        }

        System.out.println(ans);
    }

    private static int[] initFact(int M) {
        int[] fact = new int[M];
        fact[0] = 1;

        for (int i = 1; i < M; i++) {
            fact[i] = fact[i - 1] * i % M;
        }

        return fact;
    }

    private static int[] initInvFact(int M, int[] fact) {
        int[] invFact = new int[M];
        invFact[M - 1] = modPow(fact[M - 1], M - 2, M);  // 역팩토리얼의 초항(페르마의 소정리 활용)

        for (int i = M - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % M;
        }

        return invFact;
    }

    // a^b % mod를 구하는 메서드(분할 정복을 이용한 거듭제곱)
    private static int modPow(int a, int b, int mod) {
        if (b == 0) return 1;

        int half = modPow(a, b / 2, mod);
        if (b % 2 == 0) {
            return half * half % mod;
        } else {
            return half * half % mod * a % mod;  // half * half * a가 int형 범위를 넘어갈 수 있어서 미리 mod 수행
        }
    }
}
