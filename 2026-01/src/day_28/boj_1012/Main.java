package day_28.boj_1012;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j]) {
                        bfs(i, j, N, M, map);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int sr, int sc, int N, int M, boolean[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        map[sr][sc] = false;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (!map[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                map[nr][nc] = false;
            }
        }
    }
}
