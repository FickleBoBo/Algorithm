package day_29.boj_6593;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int h, n, m;
    static char[][][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (h == 0 && n == 0 && m == 0) break;

            grid = new char[h][n][m];
            int[] start = new int[3];
            int[] end = new int[3];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < m; k++) {
                        if (grid[i][j][k] == 'S') {
                            start = new int[]{i, j, k};
                        } else if (grid[i][j][k] == 'E') {
                            end = new int[]{i, j, k};
                        }
                    }
                }
                br.readLine();
            }

            int dist = bfs(start, end);
            if (dist == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(dist).append(" minute(s).\n");
            }
        }

        System.out.println(sb);
    }

    static int bfs(int[] start, int[] end) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        boolean[][][] vis = new boolean[h][n][m];
        vis[start[0]][start[1]][start[2]] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == end[0] && cur[1] == end[1] && cur[2] == end[2]) return dist;

                for (int d = 0; d < 6; d++) {
                    int nz = cur[0] + dz[d];
                    int nr = cur[1] + dr[d];
                    int nc = cur[2] + dc[d];

                    if (nz < 0 || nz >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (grid[nz][nr][nc] == '#' || vis[nz][nr][nc]) continue;

                    q.offer(new int[]{nz, nr, nc});
                    vis[nz][nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
