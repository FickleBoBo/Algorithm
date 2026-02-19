package day_17.boj_16493;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] days = new int[m];
        int[] pages = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + n];
        for (int i = 0; i < m; i++) {
            int day = days[i];
            int page = pages[i];

            for (int j = n; j >= day; j--) {
                dp[j] = Math.max(dp[j - day] + page, dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
