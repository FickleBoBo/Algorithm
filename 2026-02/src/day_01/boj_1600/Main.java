package day_01.boj_1600;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static final int[] drh = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] dch = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(K, H, W, map);
        System.out.println(result);
    }

    static int bfs(int K, int H, int W, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        boolean[][][] visited = new boolean[H][W][1 + K];
        visited[0][0][0] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                if (node[0] == H - 1 && node[1] == W - 1) return dist;

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];
                    int nk = node[2];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] == 1 || visited[nr][nc][nk]) continue;

                    q.offer(new int[]{nr, nc, nk});
                    visited[nr][nc][nk] = true;
                }

                if (node[2] == K) continue;

                for (int d = 0; d < 8; d++) {
                    int nr = node[0] + drh[d];
                    int nc = node[1] + dch[d];
                    int nk = node[2] + 1;

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] == 1 || visited[nr][nc][nk]) continue;

                    q.offer(new int[]{nr, nc, nk});
                    visited[nr][nc][nk] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
