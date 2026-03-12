package day_01.boj_1600;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] drh = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dch = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int h, w;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(k));
    }

    static int bfs(int k) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        boolean[][][] vis = new boolean[h][w][1 + k];
        vis[0][0][0] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == h - 1 && cur[1] == w - 1) return dist;

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                    if (grid[nr][nc] == 1 || vis[nr][nc][cur[2]]) continue;

                    q.offer(new int[]{nr, nc, cur[2]});
                    vis[nr][nc][cur[2]] = true;
                }

                if (cur[2] == k) continue;

                for (int d = 0; d < 8; d++) {
                    int nr = cur[0] + drh[d];
                    int nc = cur[1] + dch[d];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                    if (grid[nr][nc] == 1 || vis[nr][nc][cur[2] + 1]) continue;

                    q.offer(new int[]{nr, nc, cur[2] + 1});
                    vis[nr][nc][cur[2] + 1] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
