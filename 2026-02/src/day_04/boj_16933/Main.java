package day_04.boj_16933;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;

    static class Node {
        int r, c;
        int x;
        int day;  // 낮=0, 밤=1

        public Node(int r, int c, int x, int day) {
            this.r = r;
            this.c = c;
            this.x = x;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(k));
    }

    static int bfs(int k) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 0));

        boolean[][][][] vis = new boolean[n][m][1 + k][2];
        vis[0][0][0][0] = true;

        int dist = 1;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                Node cur = q.poll();
                if (cur.r == n - 1 && cur.c == m - 1) return dist;

                boolean flag = false;
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                    if (grid[nr][nc] == '0') {
                        if (vis[nr][nc][cur.x][1 - cur.day]) continue;

                        q.offer(new Node(nr, nc, cur.x, 1 - cur.day));
                        vis[nr][nc][cur.x][1 - cur.day] = true;
                    } else {
                        if (cur.day == 0) {
                            if (cur.x >= k) continue;
                            if (vis[nr][nc][cur.x + 1][1 - cur.day]) continue;

                            q.offer(new Node(nr, nc, cur.x + 1, 1 - cur.day));
                            vis[nr][nc][cur.x + 1][1 - cur.day] = true;
                        } else {
                            flag = true;
                        }
                    }
                }

                if (flag) {
                    if (vis[cur.r][cur.c][cur.x][1 - cur.day]) continue;

                    q.offer(new Node(cur.r, cur.c, cur.x, 1 - cur.day));
                    vis[cur.r][cur.c][cur.x][1 - cur.day] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
