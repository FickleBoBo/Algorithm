package day_19.boj_19645;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[1 + sum][1 + sum];
        dp[0][0] = true;  // 세 명 다 어떤 햄버거도 먹지 않았음
        for (int x : arr) {
            for (int i = sum; i >= 0; i--) {
                for (int j = sum; j >= 0; j--) {
                    if (dp[i][j]) {
                        dp[i + x][j] = true;
                        dp[i][j + x] = true;
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
