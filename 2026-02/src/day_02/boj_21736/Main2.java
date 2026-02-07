package day_02.boj_21736;

import java.io.*;
import java.util.*;

public class Main2 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        int sr = -1;
        int sc = -1;

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'I') {
                    sr = i;
                    sc = j;
                }
            }
        }

        visited = new boolean[n][m];

        int cnt = dfs(sr, sc);
        if (cnt > 0) {
            System.out.println(cnt);
        } else {
            System.out.println("TT");
        }
    }

    static int dfs(int r, int c) {
        visited[r][c] = true;
        int cnt = 0;
        if (grid[r][c] == 'P') cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nr][nc] == 'X' || visited[nr][nc]) continue;

            cnt += dfs(nr, nc);
        }

        return cnt;
    }
}
