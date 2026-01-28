package day_29.boj_6593;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dh = {0, 0, 0, 0, -1, 1};
    static final int[] dr = {-1, 0, 1, 0, 0, 0};
    static final int[] dc = {0, 1, 0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] building = new char[L][R][C];
            int[] start = new int[3];
            int[] end = new int[3];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = br.readLine();

                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = input.charAt(k);

                        if (building[i][j][k] == 'S') {
                            start = new int[]{i, j, k};
                        } else if (building[i][j][k] == 'E') {
                            end = new int[]{i, j, k};
                        }
                    }
                }
                br.readLine();
            }

            int dist = bfs(start, end, L, R, C, building);
            if (dist == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(dist).append(" minute(s).\n");
            }
        }

        System.out.println(sb);
    }

    static int bfs(int[] start, int[] end, int L, int R, int C, char[][][] building) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        boolean[][][] visited = new boolean[L][R][C];
        visited[start[0]][start[1]][start[2]] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                if (node[0] == end[0] && node[1] == end[1] && node[2] == end[2]) return dist;

                for (int d = 0; d < 6; d++) {
                    int nh = node[0] + dh[d];
                    int nr = node[1] + dr[d];
                    int nc = node[2] + dc[d];

                    if (nh < 0 || nh >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (building[nh][nr][nc] == '#' || visited[nh][nr][nc]) continue;

                    q.offer(new int[]{nh, nr, nc});
                    visited[nh][nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
