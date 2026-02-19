package day_01.boj_3197;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;
    static List<int[]> pos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L') pos.add(new int[]{i, j});
            }
        }

        boolean[][] visited = new boolean[n][m];
        int[][] mark = new int[n][m];
        Queue<int[]> ice = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 'X' && !visited[i][j]) {
                    Queue<int[]> result = bfs(i, j, visited);
                    ice.addAll(result);
                }
            }
        }
        bfs(ice, visited, mark);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, mark[i][j]);
            }
        }

        System.out.println(lowerBound(max, mark));
    }

    static Queue<int[]> bfs(int sr, int sc, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        visited[sr][sc] = true;

        Queue<int[]> ice = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] == 'X') {
                    ice.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    continue;
                }

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return ice;
    }

    static void bfs(Queue<int[]> q, boolean[][] visited, int[][] mark) {
        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                mark[node[0]][node[1]] = dist;

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (grid[nr][nc] != 'X' || visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }
    }

    static int lowerBound(int max, int[][] mark) {
        int left = 0;
        int right = max;

        while (left < right) {
            int mid = (left + right) / 2;

            if (!bfs(mid, mark)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    static boolean bfs(int max, int[][] mark) {
        int sr = pos.get(0)[0];
        int sc = pos.get(0)[1];
        int er = pos.get(1)[0];
        int ec = pos.get(1)[1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] visited = new boolean[n][m];
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (node[0] == er && node[1] == ec) return true;

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (mark[nr][nc] > max || visited[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return false;
    }
}
