package day_30.boj_2583;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            for (int r = sr; r < er; r++) {
                for (int c = sc; c < ec; c++) {
                    map[r][c] = true;
                }
            }
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j]) {
                    int result = bfs(i, j, N, M, map);
                    cnt++;
                    list.add(result);
                }
            }
        }
        list.sort(Comparator.naturalOrder());

        sb.append(cnt).append("\n");
        for (int x : list) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }

    static int bfs(int sr, int sc, int n, int m, boolean[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        map[sr][sc] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc]) continue;

                q.add(new int[]{nr, nc});
                map[nr][nc] = true;
                cnt++;
            }
        }

        return cnt;
    }
}
