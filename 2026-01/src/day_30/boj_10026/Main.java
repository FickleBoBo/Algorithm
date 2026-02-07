package day_30.boj_10026;

import java.io.*;
import java.util.*;

public class Main {

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

        boolean isBlind = false;
        for (int tc = 1; tc <= 2; tc++) {
            boolean[][] visited = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;

                    bfs(i, j, visited, isBlind);
                    cnt++;
                }
            }
            sb.append(cnt).append(" ");
            isBlind = !isBlind;
        }

        System.out.println(sb);
    }

    static void bfs(int sr, int sc, boolean[][] visited, boolean isBlind) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (!isSame(grid[sr][sc], grid[nr][nc], isBlind) || visited[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

    static boolean isSame(char c1, char c2, boolean isBlind) {
        if (!isBlind) return c1 == c2;
        if (c1 == 'B' || c2 == 'B') return c1 == c2;
        return true;
    }
}
