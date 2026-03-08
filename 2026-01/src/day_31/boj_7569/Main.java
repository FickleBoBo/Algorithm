package day_31.boj_7569;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] grid = new int[h][n][m];
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] dist = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        int cnt = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    grid[i][j][k] = Integer.parseInt(st.nextToken());

                    if (grid[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                        dist[i][j][k] = 0;
                    } else if (grid[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 6; d++) {
                int nz = cur[0] + dz[d];
                int nr = cur[1] + dr[d];
                int nc = cur[2] + dc[d];

                if (nz < 0 || nz >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nz][nr][nc] != 0 || dist[nz][nr][nc] != -1) continue;

                q.offer(new int[]{nz, nr, nc});
                dist[nz][nr][nc] = dist[cur[0]][cur[1]][cur[2]] + 1;
            }
        }

        int max = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (grid[i][j][k] == 0 && dist[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }

                    max = Math.max(max, dist[i][j][k]);
                }
            }
        }

        System.out.println(max);
    }
}
