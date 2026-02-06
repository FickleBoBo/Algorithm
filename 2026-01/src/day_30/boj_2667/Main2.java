package day_30.boj_2667;

import java.io.*;
import java.util.*;

public class Main2 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    list.add(dfs(i, j));
                }
            }
        }
        list.sort(Comparator.naturalOrder());

        sb.append(cnt).append("\n");
        for (int x : list) {
            sb.append(x).append("\n");
        }

        System.out.println(sb);
    }

    static int dfs(int r, int c) {
        grid[r][c] = '0';
        int cnt = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (grid[nr][nc] == '0') continue;

            cnt += dfs(nr, nc);
        }

        return cnt;
    }
}
