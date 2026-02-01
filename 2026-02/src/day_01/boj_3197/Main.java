package day_01.boj_3197;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        List<int[]> pos = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') pos.add(new int[]{i, j});
            }
        }

        boolean[][] visited = new boolean[R][C];
        int[][] mark = new int[R][C];
        Queue<int[]> ice = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    Queue<int[]> result = bfs(i, j, R, C, map, visited);
                    ice.addAll(result);
                }
            }
        }
        bfs(ice, R, C, map, visited, mark);

        int max = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                max = Math.max(max, mark[i][j]);
            }
        }

        System.out.println(lowerBound(pos, max, R, C, mark));
    }

    static Queue<int[]> bfs(int sr, int sc, int R, int C, char[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        visited[sr][sc] = true;

        Queue<int[]> ice = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 'X') {
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

    static void bfs(Queue<int[]> q, int R, int C, char[][] map, boolean[][] visited, int[][] mark) {
        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                mark[node[0]][node[1]] = dist;

                for (int d = 0; d < 4; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (map[nr][nc] != 'X' || visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }
    }

    static int lowerBound(List<int[]> pos, int max, int R, int C, int[][] mark) {
        int left = 0;
        int right = max;

        while (left < right) {
            int mid = (left + right) / 2;

            if (!bfs(pos, mid, R, C, mark)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    static boolean bfs(List<int[]> pos, int max, int R, int C, int[][] mark) {
        int sr = pos.get(0)[0];
        int sc = pos.get(0)[1];
        int er = pos.get(1)[0];
        int ec = pos.get(1)[1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] visited = new boolean[R][C];
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (node[0] == er && node[1] == ec) return true;

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (mark[nr][nc] > max || visited[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return false;
    }
}
