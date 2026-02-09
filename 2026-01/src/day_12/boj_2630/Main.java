package day_12.boj_2630;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] grid;
    static int[] cnt = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, n, n);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }

    static void recur(int r1, int c1, int r2, int c2) {
        boolean flag = true;
        int color = grid[r1][c1];

        out:
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (grid[i][j] != color) {
                    flag = false;
                    break out;
                }
            }
        }

        if (flag) {
            cnt[color]++;
        } else {
            int mr = (r1 + r2) / 2;
            int mc = (c1 + c2) / 2;

            recur(r1, c1, mr, mc);
            recur(r1, mc, mr, c2);
            recur(mr, c1, r2, mc);
            recur(mr, mc, r2, c2);
        }
    }
}
