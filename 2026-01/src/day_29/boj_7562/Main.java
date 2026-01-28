package day_29.boj_7562;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
    static final int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int len = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            int dist = bfs(sr, sc, er, ec, len);
            sb.append(dist).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int sr, int sc, int er, int ec, int len) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] visited = new boolean[len][len];
        visited[sr][sc] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                if (node[0] == er && node[1] == ec) return dist;

                for (int d = 0; d < 8; d++) {
                    int nr = node[0] + dr[d];
                    int nc = node[1] + dc[d];

                    if (nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
                    if (visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
