package day_31.boj_14940;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int sr = -1;
        int sc = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sr = i;
                    sc = j;
                }
            }
        }

        int[][] result = bfs(sr, sc, n, m, map);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] bfs(int sr, int sc, int n, int m, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] visited = new boolean[n][m];
        visited[sr][sc] = true;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -map[i][j];
            }
        }
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[node[0]][node[1]] + 1;
                }
            }
        }

        return dist;
    }
}
