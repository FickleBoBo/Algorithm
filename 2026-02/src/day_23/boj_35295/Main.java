package day_23.boj_35295;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] isPrime = sieve();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = arr[n - 2];
        int y = arr[n - 1];
        if (x == 1 && isPrime[y]) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(2);
            System.out.println(x + " " + y);
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
