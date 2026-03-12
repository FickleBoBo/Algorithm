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

        dfs(0, 0, n, n);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    static void dfs(int sr, int sc, int er, int ec) {
        boolean flag = true;
        int color = grid[sr][sc];

        out:
        for (int r = sr; r < er; r++) {
            for (int c = sc; c < ec; c++) {
                if (grid[r][c] != color) {
                    flag = false;
                    break out;
                }
            }
        }

        if (flag) {
            cnt[color + 1]++;
        } else {
            int mr1 = sr + (er - sr) / 3;
            int mc1 = sc + (ec - sc) / 3;
            int mr2 = sr + (er - sr) / 3 * 2;
            int mc2 = sc + (ec - sc) / 3 * 2;

            dfs(sr, sc, mr1, mc1);
            dfs(sr, mc1, mr1, mc2);
            dfs(sr, mc2, mr1, ec);
            dfs(mr1, sc, mr2, mc1);
            dfs(mr1, mc1, mr2, mc2);
            dfs(mr1, mc2, mr2, ec);
            dfs(mr2, sc, er, mc1);
            dfs(mr2, mc1, er, mc2);
            dfs(mr2, mc2, er, ec);
        }
    }
}
