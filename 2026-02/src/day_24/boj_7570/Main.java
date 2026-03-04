package day_24.boj_7570;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + n];
        for (int x : arr) {
            dp[x] = dp[x - 1] + 1;
        }

        int max = 0;
        for (int x : dp) {
            max = Math.max(max, x);
        }

        System.out.println(n - max);
    }
}
