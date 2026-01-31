package day_31.boj_2644;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        boolean[][] adj = new boolean[1 + n][1 + n];

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = adj[y][x] = true;
        }

        int dist = bfs(a, b, n, adj);
        System.out.println(dist);
    }

    static int bfs(int a, int b, int n, boolean[][] adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(a);

        boolean[] visited = new boolean[1 + n];
        visited[a] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                if (node == b) return dist;

                for (int next = 1; next <= n; next++) {
                    if (adj[node][next] && !visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }

            dist++;
        }

        return -1;
    }
}
