package day_30.boj_10026;

import java.io.*;

public class Main2 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n;
    static char[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        boolean isBlind = false;
        for (int tc = 1; tc <= 2; tc++) {
            visited = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;

                    dfs(i, j, isBlind);
                    cnt++;
                }
            }
            sb.append(cnt).append(" ");
            isBlind = !isBlind;
        }

        System.out.println(sb);
    }

    static void dfs(int r, int c, boolean isBlind) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (!isSame(grid[r][c], grid[nr][nc], isBlind) || visited[nr][nc]) continue;

            dfs(nr, nc, isBlind);
        }
    }

    static boolean isSame(char c1, char c2, boolean isBlind) {
        if (!isBlind) return c1 == c2;
        if (c1 == 'B' || c2 == 'B') return c1 == c2;
        return true;
    }
}
