package day_31.boj_11724;

import java.io.*;
import java.util.*;

public class Main2 {

    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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

        visited = new boolean[1 + n];
        int cnt = 0;
        for (int node = 1; node <= n; node++) {
            if (visited[node]) continue;

            dfs(node);
            cnt++;
        }

        System.out.println(cnt);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int next : adj[node]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }
}
