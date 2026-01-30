package day_30.boj_1926;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int result = bfs(i, j, n, m, map);
                    cnt++;
                    max = Math.max(max, result);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    static int bfs(int sr, int sc, int n, int m, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        map[sr][sc] = 0;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == 0) continue;

                q.add(new int[]{nr, nc});
                map[nr][nc] = 0;
                cnt++;
            }
        }

        return cnt;
    }
}
