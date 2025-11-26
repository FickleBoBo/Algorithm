package day_27.boj_1978;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final int MAX = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isPrime = sieve(MAX);

        int cnt = 0;
        for (int n : arr) {
            if (isPrime[n]) cnt++;
        }

        System.out.println(cnt);
    }

    // 에라토스테네스의 체
    private static boolean[] sieve(int N) {
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
