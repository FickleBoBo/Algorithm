package day_30.boj_2468;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int h = 0; h < 100; h++) {
            visited = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] <= h || visited[i][j]) continue;

                    bfs(i, j, h);
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    static void bfs(int sr, int sc, int h) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] <= h || visited[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
