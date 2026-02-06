package day_31.boj_5567;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adj = new ArrayList[1 + n];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] visited = new boolean[1 + n];
        visited[1] = true;

        int dist = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();

                for (int next : adj[node]) {
                    if (visited[next]) continue;

                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }

            dist++;
            if (dist == 2) break;
        }

        return cnt;
    }
}
