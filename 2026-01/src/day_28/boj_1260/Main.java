package day_28.boj_1260;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

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
        for (int i = 1; i <= n; i++) {
            adj[i].sort(Comparator.naturalOrder());
        }

        visited = new boolean[1 + n];
        dfs(k);

        sb.append("\n");

        visited = new boolean[1 + n];
        bfs(k);

        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : adj[node]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            for (int next : adj[node]) {
                if (visited[next]) continue;

                q.offer(next);
                visited[next] = true;
            }
        }
    }
}
