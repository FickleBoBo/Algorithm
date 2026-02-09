package day_30.boj_2638;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            boolean isChanged = bfs();

            if (!isChanged) break;
            time++;
        }

        System.out.println(time);
    }

    static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        boolean[][] check = new boolean[n][m];
        List<int[]> checkList = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] == 1) {
                    if (check[nr][nc]) {
                        checkList.add(new int[]{nr, nc});
                    } else {
                        check[nr][nc] = true;
                    }
                    continue;
                }

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        if (checkList.isEmpty()) return false;

        for (int[] pos : checkList) {
            grid[pos[0]][pos[1]] = 0;
        }

        return true;
    }
}
