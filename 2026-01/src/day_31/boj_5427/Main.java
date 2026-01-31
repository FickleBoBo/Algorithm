package day_31.boj_5427;

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
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            int sr = -1;
            int sc = -1;
            Queue<int[]> q = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();

                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '@') {
                        sr = i;
                        sc = j;
                    } else if (map[i][j] == '*') {
                        q.offer(new int[]{i, j});
                    }
                }
            }

            int result = bfs(sr, sc, q, h, w, map);
            if (result == -1) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int bfs(int sr, int sc, Queue<int[]> fire, int h, int w, char[][] map) {
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
                    if (map[nr][nc] == '#' || map[nr][nc] == '*') continue;

                    fire.offer(new int[]{nr, nc});
                    map[nr][nc] = '*';
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
                    if (map[nr][nc] != '.' || visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
