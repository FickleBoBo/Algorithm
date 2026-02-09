package day_12.boj_1780;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] grid;
    static int[] cnt = new int[3];

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
        System.out.println(cnt[2]);
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
            cnt[color + 1]++;
        } else {
            int mr1 = r1 + (r2 - r1) / 3;
            int mc1 = c1 + (c2 - c1) / 3;
            int mr2 = r1 + (r2 - r1) / 3 * 2;
            int mc2 = c1 + (c2 - c1) / 3 * 2;

            recur(r1, c1, mr1, mc1);
            recur(r1, mc1, mr1, mc2);
            recur(r1, mc2, mr1, c2);
            recur(mr1, c1, mr2, mc1);
            recur(mr1, mc1, mr2, mc2);
            recur(mr1, mc2, mr2, c2);
            recur(mr2, c1, r2, mc1);
            recur(mr2, mc1, r2, mc2);
            recur(mr2, mc2, r2, c2);
        }
    }
}
