package day_09.boj_12847;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] psum = new long[1 + n];
        for (int i = 1; i <= n; i++) {
            psum[i] = psum[i - 1] + arr[i - 1];
        }

        long max = 0;
        for (int i = 0; i <= n - m; i++) {
            max = Math.max(max, psum[i + m] - psum[i]);
        }

        System.out.println(max);
    }
}
