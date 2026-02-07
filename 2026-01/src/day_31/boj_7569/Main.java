package day_31.boj_7569;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int h, n, m;
    static int[][][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        grid = new int[h][n][m];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[h][n][m];
        int cnt = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    grid[i][j][k] = Integer.parseInt(st.nextToken());

                    if (grid[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    } else if (grid[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(cnt);
        } else {
            System.out.println(bfs(q, visited, cnt));
        }
    }

    static int bfs(Queue<int[]> q, boolean[][][] visited, int cnt) {
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();

                for (int d = 0; d < 6; d++) {
                    int nz = node[0] + dz[d];
                    int nr = node[1] + dr[d];
                    int nc = node[2] + dc[d];

                    if (nz < 0 || nz >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (grid[nz][nr][nc] != 0 || visited[nz][nr][nc]) continue;

                    q.offer(new int[]{nz, nr, nc});
                    visited[nz][nr][nc] = true;
                    cnt--;
                }
            }

            dist++;
            if (cnt == 0) return dist;
        }

        return -1;
    }
}
