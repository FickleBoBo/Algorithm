package day_04.boj_14442;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(k));
    }

    static int bfs(int k) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        boolean[][][] visited = new boolean[n][m][1 + k];
        visited[0][0][0] = true;

        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                if (node[0] == n - 1 && node[1] == m - 1) return dist;

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                    if (grid[nr][nc] == '0') {
                        if (visited[nr][nc][node[2]]) continue;

                        q.offer(new int[]{nr, nc, node[2]});
                        visited[nr][nc][node[2]] = true;
                    } else {
                        if (node[2] >= k) continue;
                        if (visited[nr][nc][node[2] + 1]) continue;

                        q.offer(new int[]{nr, nc, node[2] + 1});
                        visited[nr][nc][node[2] + 1] = true;
                    }
                }
            }

            dist++;
        }

        return -1;
    }
}
