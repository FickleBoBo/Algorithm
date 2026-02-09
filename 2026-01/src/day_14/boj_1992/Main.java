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

        recur(0, 0, n, n);

        System.out.println(sb);
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
            sb.append(grid[r1][c1]);
        } else {
            sb.append("(");

            int mr = (r1 + r2) / 2;
            int mc = (c1 + c2) / 2;

            recur(r1, c1, mr, mc);
            recur(r1, mc, mr, c2);
            recur(mr, c1, r2, mc);
            recur(mr, mc, r2, c2);

            sb.append(")");
        }
    }
}
