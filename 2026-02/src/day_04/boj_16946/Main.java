package day_04.boj_16946;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] cntGrid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][m];
        cntGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') cntGrid[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' || visited[i][j]) continue;

                bfs(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(cntGrid[i][j] % 10);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        visited[sr][sc] = true;

        int cnt = 1;

        Queue<int[]> q2 = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] == '1') {
                    q2.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    continue;
                }

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                cnt++;
            }
        }

        while (!q2.isEmpty()) {
            int[] node = q2.poll();
            cntGrid[node[0]][node[1]] += cnt;
            visited[node[0]][node[1]] = false;
        }
    }
}
