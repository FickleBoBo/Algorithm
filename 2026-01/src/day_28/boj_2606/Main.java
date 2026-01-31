package day_28.boj_2606;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[][] adj = new boolean[1 + N][1 + N];

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = adj[y][x] = true;
        }

        int result = bfs(N, adj);
        System.out.println(result);
    }

    static int bfs(int N, boolean[][] adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] visited = new boolean[1 + N];
        visited[1] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next = 1; next <= N; next++) {
                if (adj[node][next] && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
