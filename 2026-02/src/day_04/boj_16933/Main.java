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

        boolean[][][][] visited = new boolean[n][m][1 + k][2];
        visited[0][0][0][0] = true;

        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Node node = q.poll();
                if (node.r == n - 1 && node.c == m - 1) return dist;

                boolean flag = false;
                for (int d = 0; d < 4; d++) {
                    int nr = node.r + dr[d];
                    int nc = node.c + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                    if (grid[nr][nc] == '0') {
                        if (visited[nr][nc][node.x][1 - node.day]) continue;

                        q.offer(new Node(nr, nc, node.x, 1 - node.day));
                        visited[nr][nc][node.x][1 - node.day] = true;
                    } else {
                        if (node.day == 0) {
                            if (node.x >= k) continue;
                            if (visited[nr][nc][node.x + 1][1 - node.day]) continue;

                            q.offer(new Node(nr, nc, node.x + 1, 1 - node.day));
                            visited[nr][nc][node.x + 1][1 - node.day] = true;
                        } else {
                            flag = true;
                        }
                    }
                }

                if (flag) {
                    if (visited[node.r][node.c][node.x][1 - node.day]) continue;

                    q.offer(new Node(node.r, node.c, node.x, 1 - node.day));
                    visited[node.r][node.c][node.x][1 - node.day] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
