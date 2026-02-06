package day_31.boj_2644;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        adj = new boolean[1 + n][1 + n];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = adj[v][u] = true;
        }

        System.out.println(bfs(x, y));
    }

    static int bfs(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);

        boolean[] visited = new boolean[1 + n];
        visited[x] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                if (node == y) return dist;

                for (int next = 1; next <= n; next++) {
                    if (!adj[node][next] || visited[next]) continue;

                    q.offer(next);
                    visited[next] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
