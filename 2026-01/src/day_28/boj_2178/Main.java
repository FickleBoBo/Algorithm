package day_28.boj_2178;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int dist = bfs(N, M, map);
        System.out.println(dist);
    }

    static int bfs(int N, int M, char[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                if (node[0] == N - 1 && node[1] == M - 1) return dist;

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nr][nc] == '0' || visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
