package day_14.boj_1992;

import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, n, n);

        System.out.println(sb);
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
            sb.append(grid[sr][sc]);
        } else {
            sb.append("(");

            int mr = (sr + er) / 2;
            int mc = (sc + ec) / 2;

            dfs(sr, sc, mr, mc);
            dfs(sr, mc, mr, ec);
            dfs(mr, sc, er, mc);
            dfs(mr, mc, er, ec);

            sb.append(")");
        }
    }
}
