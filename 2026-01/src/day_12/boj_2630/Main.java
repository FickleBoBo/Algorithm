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

        dfs(0, 0, n, n);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
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
            cnt[color]++;
        } else {
            int mr = (sr + er) / 2;
            int mc = (sc + ec) / 2;

            dfs(sr, sc, mr, mc);
            dfs(sr, mc, mr, ec);
            dfs(mr, sc, er, mc);
            dfs(mr, mc, er, ec);
        }
    }
}
