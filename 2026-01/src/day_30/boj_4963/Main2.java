package day_30.boj_4963;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    static int h;
    static int w;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 || h == 0) break;

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int r, int c) {
        map[r][c] = 0;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
            if (map[nr][nc] == 0) continue;

            dfs(nr, nc);
        }
    }
}
