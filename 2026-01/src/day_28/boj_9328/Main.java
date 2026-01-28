package day_28.boj_9328;

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
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int N = 1 + h + 1;
            int M = 1 + w + 1;

            char[][] map = new char[N][M];
            for (int i = 0; i < N; i++) {
                map[i][0] = map[i][M - 1] = '.';
            }
            for (int j = 0; j < M; j++) {
                map[0][j] = map[N - 1][j] = '.';
            }
            for (int i = 1; i <= h; i++) {
                String input = br.readLine();

                for (int j = 1; j <= w; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }

            boolean[] hasKey = new boolean[26];

            String str = br.readLine();
            if (!str.equals("0")) {
                for (char c : str.toCharArray()) {
                    hasKey[c - 'a'] = true;
                }
            }

            int cnt = bfs(N, M, map, hasKey);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isKey(char c) {
        return 'a' <= c && c <= 'z';
    }

    static boolean isDoor(char c) {
        return 'A' <= c && c <= 'Z';
    }

    static int bfs(int N, int M, char[][] map, boolean[] hasKey) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        Queue<int[]>[] doors = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            doors[i] = new ArrayDeque<>();
        }

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (map[node[0]][node[1]] == '$') cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == '*' || visited[nr][nc]) continue;

                if (isDoor(map[nr][nc])) {
                    if (!hasKey[map[nr][nc] - 'A']) {
                        doors[map[nr][nc] - 'A'].offer(new int[]{nr, nc});
                        continue;
                    }
                }

                if (isKey(map[nr][nc])) {
                    hasKey[map[nr][nc] - 'a'] = true;
                    q.addAll(doors[map[nr][nc] - 'a']);
                }

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return cnt;
    }
}
