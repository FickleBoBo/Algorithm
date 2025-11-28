package day_28.boj_2485;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = gcd(arr[1] - arr[0], arr[2] - arr[1]);
        for (int i = 3; i < N; i++) {
            gcd = gcd(gcd, arr[i] - arr[i - 1]);
        }

        System.out.println((arr[N - 1] - arr[0]) / gcd + 1 - N);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
