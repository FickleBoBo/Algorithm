package day_04.boj_16946;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;
    static boolean[][] vis;
    static int[][] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        vis = new boolean[n][m];
        chk = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') chk[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' || vis[i][j]) continue;
                bfs(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(chk[i][j] % 10);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        vis[sr][sc] = true;

        int cnt = 1;

        Queue<int[]> q2 = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (vis[nr][nc]) continue;
                if (grid[nr][nc] == '1') {
                    q2.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                    continue;
                }

                q.offer(new int[]{nr, nc});
                vis[nr][nc] = true;
                cnt++;
            }
        }

        while (!q2.isEmpty()) {
            int[] cur = q2.poll();
            chk[cur[0]][cur[1]] += cnt;
            vis[cur[0]][cur[1]] = false;
        }
    }
}
