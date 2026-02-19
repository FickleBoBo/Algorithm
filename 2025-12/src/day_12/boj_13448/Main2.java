package day_12.boj_13448;

import java.io.*;
import java.util.*;

public class Main2 {

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

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        String[] marr = br.readLine().split(" ");
        String[] parr = br.readLine().split(" ");
        String[] rarr = br.readLine().split(" ");

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(Integer.parseInt(marr[i]), Long.parseLong(parr[i]), Integer.parseInt(rarr[i]));
        }
        Arrays.sort(items, (o1, o2) -> Long.compare(o1.r * o2.p, o1.p * o2.r));

        long[] dp = new long[1 + t];
        for (Item item : items) {
            int m = item.m;
            long p = item.p;
            int r = item.r;

            for (int j = t; j >= r; j--) {
                dp[j] = Math.max(dp[j - r] + (m - j * p), dp[j]);
            }
        }

        long max = 0;
        for (int j = 1; j <= t; j++) {
            max = Math.max(max, dp[j]);
        }

        System.out.println(max);
    }
}
