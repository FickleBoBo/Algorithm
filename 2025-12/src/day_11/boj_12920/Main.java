package day_11.boj_12920;

import java.io.*;
import java.util.*;

public class Main {

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

        int[][] dp = new int[1 + items.size()][1 + m];
        for (int i = 1; i <= items.size(); i++) {
            int v = items.get(i - 1).v;
            int c = items.get(i - 1).c;

            for (int j = 1; j <= m; j++) {
                if (j < v) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - v] + c, dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[items.size()][m]);
    }
}
