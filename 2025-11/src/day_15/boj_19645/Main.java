package day_15.boj_19645;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[1 + sum][1 + sum];
        dp[0][0] = true;
        for (int n : arr) {
            for (int i = sum; i >= 0; i--) {
                for (int j = sum; j >= 0; j--) {
                    if (dp[i][j]) {
                        dp[i + n][j] = true;
                        dp[i][j + n] = true;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= sum; i++) {
            for (int j = i; j <= sum; j++) {
                if (dp[i][j] && (sum - i - j) <= i) {
                    max = Math.max(max, sum - i - j);
                }
            }
        }

        System.out.println(max);
    }
}
