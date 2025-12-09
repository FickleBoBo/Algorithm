package day_09.boj_12847;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] pSum = new long[1 + N];
        for (int i = 1; i <= N; i++) {
            pSum[i] = pSum[i - 1] + arr[i - 1];
        }

        long max = 0;
        for (int i = 0; i <= N - M; i++) {
            max = Math.max(max, pSum[i + M] - pSum[i]);
        }

        System.out.println(max);
    }
}
