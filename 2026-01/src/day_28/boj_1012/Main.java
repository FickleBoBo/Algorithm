package day_28.boj_1012;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static boolean[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            grid = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                grid[r][c] = true;
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j]) {
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

        grid[sr][sc] = false;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (!grid[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                grid[nr][nc] = false;
            }
        }
    }
}
