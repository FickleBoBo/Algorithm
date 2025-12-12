package day_12.boj_7579;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] mArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cArr = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += cArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + sum];
        for (int i = 0; i < N; i++) {
            int m = mArr[i];
            int c = cArr[i];

            for (int j = sum; j >= c; j--) {
                dp[j] = Math.max(dp[j - c] + m, dp[j]);
            }
        }

        for (int j = 0; j <= sum; j++) {
            if (dp[j] >= M) {
                System.out.println(j);
                return;
            }
        }
    }
}
