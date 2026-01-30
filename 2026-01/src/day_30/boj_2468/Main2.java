package day_30.boj_2468;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int h = 0; h < 100; h++) {
            visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= h || visited[i][j]) continue;

                    dfs(i, j, h);
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    static void dfs(int r, int c, int h) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (map[nr][nc] <= h || visited[nr][nc]) continue;

            dfs(nr, nc, h);
        }
    }
}
