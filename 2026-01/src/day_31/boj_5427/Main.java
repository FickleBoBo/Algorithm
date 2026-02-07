package day_31.boj_5427;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int h, w;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            grid = new char[h][w];
            int sr = -1;
            int sc = -1;
            Queue<int[]> q = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                grid[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] == '@') {
                        sr = i;
                        sc = j;
                    } else if (grid[i][j] == '*') {
                        q.offer(new int[]{i, j});
                    }
                }
            }

            int result = bfs(sr, sc, q);
            if (result == -1) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int bfs(int sr, int sc, Queue<int[]> fire) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] visited = new boolean[h][w];
        visited[sr][sc] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = fire.size();

            while (size-- > 0) {
                int[] node = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                    if (grid[nr][nc] == '#' || grid[nr][nc] == '*') continue;

                    fire.offer(new int[]{nr, nc});
                    grid[nr][nc] = '*';
                }
            }

            size = q.size();
            while (size-- > 0) {
                int[] node = q.poll();
                if (node[0] == 0 || node[0] == h - 1 || node[1] == 0 || node[1] == w - 1) return dist + 1;

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                    if (grid[nr][nc] != '.' || visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
