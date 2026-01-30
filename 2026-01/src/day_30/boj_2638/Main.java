package day_30.boj_2638;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            boolean isChanged = bfs(N, M, map);

            if (!isChanged) break;
            time++;
        }

        System.out.println(time);
    }

    static boolean bfs(int N, int M, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        boolean[][] check = new boolean[N][M];
        List<int[]> checkList = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 1) {
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
            map[pos[0]][pos[1]] = 0;
        }

        return true;
    }
}
