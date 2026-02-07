package day_01.boj_10163;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] grid = new int[1001][1001];

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int rlen = Integer.parseInt(st.nextToken());
            int clen = Integer.parseInt(st.nextToken());

            for (int r = sr; r < sr + rlen; r++) {
                for (int c = sc; c < sc + clen; c++) {
                    grid[r][c] = i;
                }
            }
        }

        int[] cnt = new int[1 + n];
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                cnt[grid[i][j]]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(cnt[i]).append("\n");
        }

        System.out.print(sb);
    }
}
