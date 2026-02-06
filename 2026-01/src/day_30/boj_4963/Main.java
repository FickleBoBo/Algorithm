package day_30.boj_4963;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int h, w;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 || h == 0) break;

            grid = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        grid[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 8; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (grid[nr][nc] == 0) continue;

                q.offer(new int[]{nr, nc});
                grid[nr][nc] = 0;
            }
        }
    }
}
