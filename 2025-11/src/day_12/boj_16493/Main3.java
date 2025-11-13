package day_12.boj_16493;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] days = new int[M];
        int[] pages = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + N];
        for (int i = 0; i < M; i++) {
            int day = days[i];
            int page = pages[i];

            for (int j = N; j >= day; j--) {
                dp[j] = Math.max(dp[j - day] + page, dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
