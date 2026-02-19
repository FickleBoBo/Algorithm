package day_11.boj_12920;

import java.io.*;
import java.util.*;

public class Main2 {

    static class Item {
        int v;
        int c;

        public Item(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 이진 그룹핑
            for (int bit = 1; bit <= k; bit <<= 1) {
                items.add(new Item(v * bit, c * bit));
                k -= bit;
            }

            // 나머지가 존재하면 그룹핑
            if (k != 0) {
                items.add(new Item(v * k, c * k));
            }
        }

        int[] dp = new int[1 + m];
        for (Item item : items) {
            int v = item.v;
            int c = item.c;

            for (int j = m; j >= v; j--) {
                dp[j] = Math.max(dp[j - v] + c, dp[j]);
            }
        }

        System.out.println(dp[m]);
    }
}
