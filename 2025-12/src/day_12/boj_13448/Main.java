package day_12.boj_13448;

import java.io.*;
import java.util.*;

public class Main {

    static class Item {
        int m;
        long p;  // 점수 계산에서 오버플로우 방지
        int r;

        public Item(int m, long p, int r) {
            this.m = m;
            this.p = p;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        String[] M = br.readLine().split(" ");
        String[] P = br.readLine().split(" ");
        String[] R = br.readLine().split(" ");

        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            items[i] = new Item(Integer.parseInt(M[i]), Long.parseLong(P[i]), Integer.parseInt(R[i]));
        }
        Arrays.sort(items, (o1, o2) -> Long.compare(o1.r * o2.p, o1.p * o2.r));

        long[][] dp = new long[1 + N][1 + T];
        for (int i = 1; i <= N; i++) {
            Item item = items[i - 1];
            int m = item.m;
            long p = item.p;
            int r = item.r;

            for (int j = 1; j <= T; j++) {
                if (j < r) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - r] + (m - j * p), dp[i - 1][j]);
                }
            }
        }

        long max = 0;
        for (int j = 1; j <= T; j++) {
            max = Math.max(max, dp[N][j]);
        }

        System.out.println(max);
    }
}
