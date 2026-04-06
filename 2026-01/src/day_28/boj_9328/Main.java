package day_28.boj_9328;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            n = 1 + h + 1;
            m = 1 + w + 1;

            grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i][0] = grid[i][m - 1] = '.';
            }
            for (int j = 0; j < m; j++) {
                grid[0][j] = grid[n - 1][j] = '.';
            }

            for (int i = 1; i <= h; i++) {
                String input = br.readLine();
                for (int j = 1; j <= w; j++) {
                    grid[i][j] = input.charAt(j - 1);
                }
            }

            boolean[] hasKey = new boolean[26];

            String s = br.readLine();
            if (!s.equals("0")) {
                for (char c : s.toCharArray()) {
                    hasKey[c - 'a'] = true;
                }
            }

            sb.append(bfs(hasKey)).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isKey(char c) {
        return 'a' <= c && c <= 'z';
    }

    static boolean isDoor(char c) {
        return 'A' <= c && c <= 'Z';
    }

    static int bfs(boolean[] hasKey) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        Queue<int[]>[] doors = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            doors[i] = new ArrayDeque<>();
        }

        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (grid[cur[0]][cur[1]] == '$') cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] == '*' || vis[nr][nc]) continue;

                if (isDoor(grid[nr][nc])) {
                    if (!hasKey[grid[nr][nc] - 'A']) {
                        doors[grid[nr][nc] - 'A'].offer(new int[]{nr, nc});
                        vis[nr][nc] = true;
                        continue;
                    }
                }

                if (isKey(grid[nr][nc])) {
                    hasKey[grid[nr][nc] - 'a'] = true;
                    q.addAll(doors[grid[nr][nc] - 'a']);
                }

                q.offer(new int[]{nr, nc});
                vis[nr][nc] = true;
            }
        }

        return cnt;
    }
}
