package day_30.boj_2468;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int h = 0; h < 100; h++) {
            boolean[][] visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= h || visited[i][j]) continue;

                    bfs(i, j, h, N, map, visited);
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    static void bfs(int sr, int sc, int h, int N, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc] <= h || visited[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
