package day_11.boj_13448;

import java.io.*;
import java.util.*;

public class Main2 {

    private static class Item {
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

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            items.add(new Item(Integer.parseInt(M[i]), Long.parseLong(P[i]), Integer.parseInt(R[i])));
        }
        items.sort((o1, o2) -> Long.compare(o1.r * o2.p, o1.p * o2.r));

        long[] dp = new long[1 + T];

        for (Item item : items) {
            int m = item.m;
            long p = item.p;
            int r = item.r;

            for (int j = T; j >= r; j--) {
                dp[j] = Math.max(dp[j - r] + (m - j * p), dp[j]);
            }
        }

        long max = 0;
        for (int i = 1; i <= T; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
