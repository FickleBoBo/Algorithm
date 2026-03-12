package day_31.boj_4179;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int h, w;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        grid = new char[h][w];
        int sr = -1;
        int sc = -1;
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < h; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 'J') {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 'F') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int res = bfs(sr, sc, q);
        if (res == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(res);
        }
    }

    static int bfs(int sr, int sc, Queue<int[]> fire) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] vis = new boolean[h][w];
        vis[sr][sc] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = fire.size();

            while (sz-- > 0) {
                int[] cur = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                    if (grid[nr][nc] == '#' || grid[nr][nc] == 'F') continue;

                    fire.offer(new int[]{nr, nc});
                    grid[nr][nc] = 'F';
                }
            }

            sz = q.size();
            while (sz-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == 0 || cur[0] == h - 1 || cur[1] == 0 || cur[1] == w - 1) return dist + 1;

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                    if (grid[nr][nc] != '.' || vis[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
