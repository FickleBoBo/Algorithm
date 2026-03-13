package day_02.boj_21736;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;

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

        int cnt = bfs(sr, sc);
        if (cnt > 0) {
            System.out.println(cnt);
        } else {
            System.out.println("TT");
        }
    }

    static int bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] vis = new boolean[n][m];
        vis[sr][sc] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (grid[cur[0]][cur[1]] == 'P') cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] == 'X' || vis[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                vis[nr][nc] = true;
            }
        }

        return cnt;
    }
}
