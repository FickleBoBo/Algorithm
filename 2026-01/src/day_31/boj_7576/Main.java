package day_31.boj_7576;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else if (grid[i][j] == 0) {
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] != 0 || dist[nr][nc] != -1) continue;

                q.offer(new int[]{nr, nc});
                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }

                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);
    }
}
