package day_11.boj_12920;

import java.io.*;
import java.util.*;

public class Main {

    private static class Item {
        int V;
        int C;

        public Item(int V, int C) {
            this.V = V;
            this.C = C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 비트마스킹을 활용한 이진 분할로 그룹핑
            for (int bit = 1; bit <= K; bit <<= 1) {
                items.add(new Item(V * bit, C * bit));
                K -= bit;
            }

            // 나머지가 존재하면 그룹핑
            if (K != 0) {
                items.add(new Item(V * K, C * K));
            }
        }

        int[][] dp = new int[1 + items.size()][1 + M];
        for (int i = 1; i <= items.size(); i++) {
            int v = items.get(i - 1).V;
            int c = items.get(i - 1).C;

            for (int j = 1; j <= M; j++) {
                if (j < v) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - v] + c, dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[items.size()][M]);
    }
}
