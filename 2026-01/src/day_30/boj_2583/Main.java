package day_30.boj_2583;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static boolean[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        grid = new boolean[n][m];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            for (int r = sr; r < er; r++) {
                for (int c = sc; c < ec; c++) {
                    grid[r][c] = true;
                }
            }
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!grid[i][j]) {
                    cnt++;
                    list.add(bfs(i, j));
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

    static int bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        grid[sr][sc] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                grid[nr][nc] = true;
                cnt++;
            }
        }

        return cnt;
    }
}
