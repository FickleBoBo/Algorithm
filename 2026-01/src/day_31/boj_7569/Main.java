package day_31.boj_7569;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dh = {0, 0, 0, 0, -1, 1};
    static final int[] dr = {-1, 0, 1, 0, 0, 0};
    static final int[] dc = {0, 1, 0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[H][N][M];
        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    if (map[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    } else if (map[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(cnt);
        } else {
            int result = bfs(q, visited, cnt, H, N, M, map);
            System.out.println(result);
        }
    }

    static int bfs(Queue<int[]> q, boolean[][][] visited, int cnt, int H, int N, int M, int[][][] map) {
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();

                for (int d = 0; d < 6; d++) {
                    int nh = node[0] + dh[d];
                    int nr = node[1] + dr[d];
                    int nc = node[2] + dc[d];

                    if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nh][nr][nc] != 0 || visited[nh][nr][nc]) continue;

                    q.offer(new int[]{nh, nr, nc});
                    visited[nh][nr][nc] = true;
                    cnt--;
                }
            }

            dist++;
            if (cnt == 0) return dist;
        }

        return -1;
    }
}
