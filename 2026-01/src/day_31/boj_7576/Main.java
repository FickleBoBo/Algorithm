package day_31.boj_7576;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            System.out.println(cnt);
        } else {
            int result = bfs(q, visited, cnt, N, M, map);
            System.out.println(result);
        }
    }

    static int bfs(Queue<int[]> q, boolean[][] visited, int cnt, int N, int M, int[][] map) {
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nr][nc] != 0 || visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    cnt--;
                }
            }

            dist++;
            if (cnt == 0) return dist;
        }

        return -1;
    }
}
